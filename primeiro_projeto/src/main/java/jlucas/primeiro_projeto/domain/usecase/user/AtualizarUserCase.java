package jlucas.primeiro_projeto.domain.usecase.user;

import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.domain.repository.UserRepository;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AtualizarUserCase
{
    private static final Logger logger = LoggerFactory.getLogger(AtualizarUserCase.class);
    @Autowired
    private UserRepository userRepository;

    public User atualizarUser(Integer id,User user) throws SemRetornoException
    {
        Optional<User> userId = userRepository.findById(id);
        if(userId.isPresent())
        {
            User userUpdate = userId.get();

            userUpdate.setNome(Objects.requireNonNullElse(user.getNome(), userUpdate.getNome()));
            userUpdate.setEmail(Objects.requireNonNullElse(user.getEmail(), userUpdate.getEmail()));
            userUpdate.setSenha(Objects.requireNonNullElse(user.getSenha(), userUpdate.getSenha()));
            userUpdate.setStatus(Objects.requireNonNullElse(user.getStatus(), userUpdate.getStatus()));


            return userRepository.save(userUpdate);
        }
        else
        {
            throw new SemRetornoException();
        }
    }
}
