package jlucas.primeiro_projeto.interfaces.controller.v1.endpointimpl;

import io.swagger.v3.oas.annotations.Operation;
import jlucas.primeiro_projeto.application.serviceimpl.UserServiceImpl;
import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.interfaces.controller.v1.endpoint.HelloHundoInterface;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import jlucas.primeiro_projeto.interfaces.output.APIResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //!!
public class HelloMundoimpl implements HelloHundoInterface
{
    @Autowired
    private UserServiceImpl userService;
    @Override
    public ResponseEntity<APIResponseDTO<List<User>>> buscarAtivos() throws SemRetornoException {
        APIResponseDTO<List<User>> response = new APIResponseDTO();

            response.setData(userService.consultaUserAtivo());
            response.setStatus("success");
            response.setMessage("Informações retornadas com sucesso.");
            return ResponseEntity.ok(response);


    }
    @GetMapping("/consultaId/{id}")
    @Operation(summary = "Consulta de Usuário por ID", description = "Consulta um usuário específico pelo ID.")

    public ResponseEntity<APIResponseDTO<User>> buscarId(@PathVariable("id")Integer id) throws SemRetornoException {
        APIResponseDTO<User> response = new APIResponseDTO<>();
        User user = userService.consultarUserId(id);
        response.setData(user);
        response.setStatus("sucess");
        return  ResponseEntity.ok(response);
    }
    @GetMapping("/consultaNome/{nome}")
    @Operation(summary = "Consulta de Usuário por ID", description = "Consulta um usuário específico pelo ID.")

    public ResponseEntity<APIResponseDTO<User>> buscarNome(@PathVariable("nome")String nome) throws SemRetornoException {
        APIResponseDTO<User> response = new APIResponseDTO<>();

            User user = userService.consultarUserNome(nome);
            response.setData(user);
            response.setStatus("sucess");
            return  ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta o Usuário por ID", description = "Deleta um usuário específico pelo ID.")
    public  ResponseEntity<APIResponseDTO<User>> deleteId(@PathVariable("id") Integer id) throws SemRetornoException {
        APIResponseDTO<User> response = new APIResponseDTO<>();
            userService.apagaUser(id);
            response.setStatus("sucess");
            return  ResponseEntity.ok(response);
    }
    @GetMapping("/consultaEmail/{email}")
    public ResponseEntity<APIResponseDTO<User>>  consultaEmail(@PathVariable("email")String email) throws SemRetornoException {
        APIResponseDTO<User> response = new APIResponseDTO<>();
            User user = userService.consultarEmail(email);
            response.setData(user);
            response.setStatus("sucess");
            return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo usuário", description = "Insere um novo usuário")
    public ResponseEntity<APIResponseDTO<User>> criaUsuario(@RequestBody User user) throws SemRetornoException
    {
        APIResponseDTO<User> response = new APIResponseDTO<>();
            User novoUser = userService.inserirUser(user);
            response.setData(novoUser);
            response.setStatus("sucess");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }


    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza um usuário", description = "Atualiza um usuário")
    public ResponseEntity<APIResponseDTO<User>> atualizaUser(@PathVariable Integer id,@RequestBody User user) throws SemRetornoException {
        APIResponseDTO<User> response = new APIResponseDTO<>();

            User novoUser = userService.atualizarUser(id,user);
            response.setData(novoUser);
            response.setStatus("sucess");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }


}

