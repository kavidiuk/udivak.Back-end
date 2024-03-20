package capstone.udivak.service;

import capstone.udivak.dto.ClientDTO;
import java.util.List;

public interface ClientService {
    public abstract List<ClientDTO> getClients();
}
