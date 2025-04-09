package jlucas.primeiro_projeto.interfaces.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetadataResponseDTO {
    private Integer total;
    private Integer page;
    private Integer per_page;
    private Integer total_pages;
}
