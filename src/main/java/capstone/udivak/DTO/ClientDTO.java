<<<<<<< Updated upstream:src/main/java/capstone/udivak/DTO/ClientDTO.java
package capstone.udivak.DTO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
public record ClientDTO (
    @NotEmpty(message = "Nome è obbligatorio ")
    String nome,
    @NotEmpty(message = "Cognome è obbligatorio ")
    String cognome,
    @NotEmpty(message = "L'email è obbligatorio ")
    String email,
    @NotEmpty(message = "La password è obbligatorio")
    String password
){
}
=======
package capstone.udivak.dto;
import jakarta.validation.constraints.NotEmpty;

public record ClientDTO (
    @NotEmpty(message = "Nome è obbligatorio ")
    String nome,
    @NotEmpty(message = "Cognome è obbligatorio ")
    String cognome,
    @NotEmpty(message = "L'email è obbligatorio ")
    String email,
    @NotEmpty(message = "La password è obbligatorio")
    String password
    //fefeofkoefka
    //dwadmiwamd
){
  // Custom constructor
   
}
>>>>>>> Stashed changes:src/main/java/capstone/udivak/dto/ClientDTO.java
