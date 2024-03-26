
package capstone.udivak.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorsPayloadWithList extends ErrorsPayloads {
    private List<String> errorsList;

    public ErrorsPayloadWithList(String message, LocalDateTime timestamp) {
        super(message, timestamp);
        this.errorsList = errorsList;
    }
}