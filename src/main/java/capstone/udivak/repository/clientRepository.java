package capstone.udivak.repository;


import capstone.udivak.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository//BEAN SPRING DI TIPO REPOSITORY
public interface ClientRepository extends JpaRepository<Client, UUID> {
    List<Client> findByNome (String name);
    List<Client> findByCognome (String cognome);
    Client findByEmail (String email);
    List<Client> findByNomeAndCognome (String name,String cognome);
    List<Client> findByNomeOrCognome (String name,String cognome);
}
