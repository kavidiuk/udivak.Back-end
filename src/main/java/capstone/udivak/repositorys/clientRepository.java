package capstone.udivak.repositorys;

import capstone.udivak.DTO.ClientDTO;
import capstone.udivak.Entities.client;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import capstone.udivak.DTO.ClientDTO.*;

import java.util.UUID;

public interface clientRepository extends JpaRepository<Client, UUID> {

    Client findClientName (String name);
    Client findClientCognome (String cognome);
    Client findByEmail (String email);

}
