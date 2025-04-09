package jlucas.primeiro_projeto.interfaces.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class APIResponseDTO<T> {
    private String status;
    private T data;
    private List<ErroResponseDTO> errors;
    private String message;
    private MetadataResponseDTO meta;


    public static <T> APIResponseDTO<T> montarResposta(String status, T data, String message, MetadataResponseDTO meta, List<ErroResponseDTO> errors) {
        APIResponseDTO<T> response = new APIResponseDTO<>();
        response.setData(data);
        response.setStatus(status);
        response.setMessage(message);
        response.setMeta(meta);
        response.setErrors(errors);
        return response;
    }

    public static <T> APIResponseDTO<T> montarRespostaNotOk(String message, List<ErroResponseDTO> errors) {
        APIResponseDTO<T> response = new APIResponseDTO<>();
        response.setData(null);
        response.setStatus("Error");
        response.setMessage(message);
        response.setMeta(null);
        response.setErrors(errors);
        return response;
    }

    public static <T> APIResponseDTO<T> montarRespostaOk(T data) {
        APIResponseDTO<T> response = new APIResponseDTO<>();
        response.setData(data);
        response.setStatus("success");
        response.setMessage("Informações retornadas com sucesso.");
        response.setMeta(null);
        response.setErrors(null);
        return response;
    }
}
