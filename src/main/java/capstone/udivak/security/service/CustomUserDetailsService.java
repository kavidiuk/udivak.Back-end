package capstone.udivak.security.service;

import capstone.udivak.security.model.RegisterRequest;
import capstone.udivak.security.model.LoginResponse;
import capstone.udivak.entities.Client;
import capstone.udivak.repository.ClientRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse register(RegisterRequest request) {
        log.info("@Register@");
        Client user = new Client();
        log.info("Email: "+request.getEmail());
        log.info("Username: "+request.getUsername());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setCognome(request.getCognome());
        user.setNome(request.getNome());

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        //saveUserToken(savedUser, jwtToken);
        
        var savedUser = clientRepository.save(user);
        
        return LoginResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("@loadUserByUsername@");
        if (clientRepository.findByUsername(username) != null) {

            Optional<Client> optUser = clientRepository.findByUsername(username);
          

            if (optUser.isPresent()) {

                Client user=optUser.get();
                
                log.info("Username: " + user.getUsername()+" email: "+user.getEmail());
                
                List<SimpleGrantedAuthority> roles = Arrays
                        .asList(new SimpleGrantedAuthority(Integer.toString(user.getId())));

                return new User(username, user.getPassword(), roles);
            }
        }
        throw new UsernameNotFoundException("User not found with the name " + username);

    }
    
    
}
