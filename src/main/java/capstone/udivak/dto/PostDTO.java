package capstone.udivak.dto;

import jakarta.validation.constraints.NotEmpty;

public record PostDTO(
    @NotEmpty(message = "Inserisci la data obbligatorio")
    String date
){
}
