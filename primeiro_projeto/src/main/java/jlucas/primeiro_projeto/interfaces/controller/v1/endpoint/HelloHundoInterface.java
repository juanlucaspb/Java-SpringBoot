package jlucas.primeiro_projeto.interfaces.controller.v1.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import jlucas.primeiro_projeto.interfaces.output.APIResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// RestController serve para usar methods
@RestController
// define a rota da interface
@RequestMapping("/api/v1/hello")

public interface HelloHundoInterface
{
    @GetMapping
    @Operation(summary = "Consultar Todos os usuários ativos", description = "Apenas para testar o primeiro endpoint criado...")
    public ResponseEntity<APIResponseDTO<List<User>>> buscarAtivos() throws SemRetornoException;

}

