package capstone.udivak.service;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.security.model.LoginRequest;
import capstone.udivak.security.model.LoginResponse;

import java.util.List;

public interface ClientService {
    public abstract List<ClientDTO> getClients();
    
    public abstract LoginResponse authenticate(LoginRequest request) throws org.springframework.security.authentication.BadCredentialsException;
}
