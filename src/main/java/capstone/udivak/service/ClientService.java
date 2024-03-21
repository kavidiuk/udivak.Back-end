package capstone.udivak.service;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.entities.Client;

import java.util.List;

public interface ClientService {
    public abstract List<ClientDTO> getClients();

    boolean deleteClient(Long clientId);

    Client getClientById(Long clientId);

    Client createClient(Client newClient);

    Client updateClient(Long clientId, Client updatedClient);
}
