package capstone.udivak.dtobuilder;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.entities.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTOBuilder {
    
    public static ClientDTO toDTO(Client client) {
	ClientDTO dto = new ClientDTO(client.getNome(),
        client.getCognome(),client.getEmail(),client.getPassword());
        return dto;
    }

    public static Client fromDTO(ClientDTO dto) {
        Client client = new Client();
        client.setCognome(dto.cognome());
        client.setNome(dto.nome());
        client.setEmail(dto.email());
        client.setCognome(dto.password());
        return client;
    }
    
    public static List<ClientDTO> toDTOList(List<Client> commesse) {
        return commesse.stream()
        .map(ClientDTOBuilder::toDTO)
        .collect(Collectors.toList());
    }

    public static List<Client> fromDTOList(List<ClientDTO> dtoList) {
        return dtoList.stream()
        .map(ClientDTOBuilder::fromDTO)
        .collect(Collectors.toList());
    }
}
