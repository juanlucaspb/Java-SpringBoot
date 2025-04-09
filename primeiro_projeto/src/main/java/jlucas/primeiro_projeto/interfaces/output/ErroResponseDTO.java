package jlucas.primeiro_projeto.interfaces.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroResponseDTO {
    private String code;
    private String message;
    private String field;
}
