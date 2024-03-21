package capstone.udivak.controllers;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.entities.Client;
import capstone.udivak.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping("/api/clients")  // Modificato il percorso base per riflettere l'entità "clienti"
public class ClientController {//Pascal Case

    @Autowired
    private ClientService clientService;//camel Case

    // Endpoint per ottenere tutti i clienti
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<ClientDTO> clients = clientService.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Endpoint per ottenere un cliente per ID
    @GetMapping("/{clientId}")  // Aggiunto l'annotazione @PathVariable per ottenere il valore dell'ID dalla URL
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Client client = clientService.getClientById(clientId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per creare un nuovo cliente
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {  // Corretto il tipo di ritorno e il nome del metodo
        Client createdClient = clientService.createClient(newClient);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un cliente esistente
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        Client client = clientService.updateClient(clientId, updatedClient);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per eliminare un cliente
    @DeleteMapping("/{clientId}")  // Aggiunto l'annotazione @PathVariable per ottenere il valore dell'ID dalla URL
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        boolean deleted = clientService.deleteClient(clientId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
