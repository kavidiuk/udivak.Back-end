/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capstone.udivak.service;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.dtobuilder.ClientDTOBuilder;
import capstone.udivak.entities.Client;
import capstone.udivak.repository.ClientRepository;
import capstone.udivak.security.model.LoginRequest;
import capstone.udivak.security.model.LoginResponse;
import capstone.udivak.security.service.JwtService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author eddie
 */
@Slf4j
@Service//BEAN SPRING DI TIPO SERVICE
public class ClientServiceImpl implements ClientService{

    @Resource
    //@Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    
    //LA LOGICA DI BUSINESS DI QUESTO 
    //METODO PREVEDE IL RECUPERO DI TUTTI I CLIENT
    //DAL DATABASE 
    //POI LA CONVERSIONE DI ESSI IN DTO
    //E ALLA FINE LA RESTITUZIONE DELLA LISTA DI TUTTI I 
    //CLIENT DTO
    @Override
    public List<ClientDTO> getClients() {
        List<Client> cls=this.clientRepository.findAll();
        return ClientDTOBuilder.toDTOList(cls);
    }
    
    @Override
    public LoginResponse authenticate(LoginRequest request) 
            throws org.springframework.security.authentication.BadCredentialsException {
        log.info("Authenticate1.1: "+request.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        log.info("Authenticate1.2: "+request.getUsername());
        
        Optional<Client> optClient = clientRepository.findByUsername(request.getUsername());
        Client user=optClient.get();
        log.info("Authenticate2: "+user.getUsername());
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        //revokeAllUserTokens(user);
        //saveUserToken(user, jwtToken);
        return LoginResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    
    
}
