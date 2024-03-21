/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capstone.udivak.service;

import capstone.udivak.dto.ClientDTO;
import capstone.udivak.entities.Client;
import capstone.udivak.dtobuilder.ClientDTOBuilder;

import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import capstone.udivak.repository.ClientRepository;

/**
 *
 * @author eddie
 */
@Service//BEAN SPRING DI TIPO SERVICE
public class ClientServiceImpl implements ClientService{

    @Resource
    //@Autowired
    private ClientRepository clientRepository;
    
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
    
}
