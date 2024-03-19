package capstone.udivak.DTO;

import jakarta.validation.constraints.NotEmpty;

public record postDTO(
    @NotEmpty(message = "Inserisci la data obbligatorio")
    String date
){
}
