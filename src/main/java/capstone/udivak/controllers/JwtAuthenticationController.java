package capstone.udivak.controllers;

import capstone.udivak.entities.Client;
import capstone.udivak.repository.ClientRepository;
import capstone.udivak.security.model.LoginRequest;
import capstone.udivak.security.model.LoginResponse;
import capstone.udivak.security.service.CustomUserDetailsService;

import capstone.udivak.security.model.JwtRequest;
import capstone.udivak.security.model.JwtResponse;
import capstone.udivak.security.service.JwtService;
import capstone.udivak.security.model.RegisterRequest;
import capstone.udivak.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(
        @RequestBody RegisterRequest request
    ) {

      return ResponseEntity.
              ok(customUserDetailsService.register(request));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login
        (@RequestBody JwtRequest authenticationRequest) 
                {
        log.info("@Login@");
        
        log.info("Username before: "+authenticationRequest.getUsername());
        
        LoginRequest ar=new 
        LoginRequest(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        
        try{
            clientService.authenticate(ar);
        
        }
        catch(org.springframework.security.authentication.BadCredentialsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }

        log.info("Username after: "+authenticationRequest.getUsername());
        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        
         log.info("UserDetails: "+userDetails.getUsername());

        // per prendere le informazioni idazienda e matricola
        // che mi servono in angular
        // MODIFICARE e farle aggiungere direttamente nel token
        Optional<Client> optC=clientRepository.findByUsername(authenticationRequest.getUsername());
        if (optC.isPresent()) {
            
            final String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token, optC.get().getNome(), optC.get().getCognome(), optC.get().getId()));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }

    }

    
//    private void authenticate(String username, String password) throws Exception {
//        Objects.requireNonNull(username);
//        Objects.requireNonNull(password);
//
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            e.printStackTrace();
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            e.printStackTrace();
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }

//  private void saveUserToken(Client user, String jwtToken) {
//    var token = Token.builder()
//        .user(user)
//        .token(jwtToken)
//        .tokenType(TokenType.BEARER)
//        .expired(false)
//        .revoked(false)
//        .build();
//    tokenRepository.save(token);
//  }
//
//  private void revokeAllUserTokens(User user) {
//    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//    if (validUserTokens.isEmpty())
//      return;
//    validUserTokens.forEach(token -> {
//      token.setExpired(true);
//      token.setRevoked(true);
//    });
//    tokenRepository.saveAll(validUserTokens);
//  }
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.clientRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                //revokeAllUserTokens(user);
                //saveUserToken(user, accessToken);
                var authResponse = LoginResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
