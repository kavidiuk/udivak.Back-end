package capstone.udivak.dto;

import jakarta.validation.constraints.NotEmpty;
import org.aspectj.bridge.IMessage;

import java.util.Date;

public record PostDTO(
    @NotEmpty()
    Date date,
    @NotEmpty()
    String post,
    @NotEmpty()
    String commenti
){
}
