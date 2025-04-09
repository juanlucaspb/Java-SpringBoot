package jlucas.primeiro_projeto.domain.usecase.user;

import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.domain.repository.UserRepository;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultarUserCase
{
    private static final Logger logger = LoggerFactory.getLogger(ConsultarUserCase.class);
    @Autowired
    private UserRepository userRepository;
    public List<User> buscaUserAtivos() throws SemRetornoException {
        logger.info("Chamada ao Metodo buscaUserAtivos");

        List<User> listaUserAtivos = userRepository.findByStatus(1);
        if(listaUserAtivos.size() == 0)
        {
            throw new SemRetornoException();
        }
        return listaUserAtivos;
    }
    public Optional<User> buscarUserId(Integer id)
    {
        return userRepository.findById(id);
    }
    public User buscarEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public Optional<User> buscarNome(String nome)
    {
        return userRepository.findByNomeContaining(nome);
    }

}
