package jlucas.primeiro_projeto.domain.usecase.user;

import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.domain.repository.UserRepository;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserCase
{
    private static final Logger logger = LoggerFactory.getLogger(DeleteUserCase.class);
    @Autowired
    private UserRepository userRepository;

    public Optional<User> deleteUser(Integer id) throws SemRetornoException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
        {

            userRepository.deleteById(id);
            logger.info("Apagado!");
            return user;

        }
        throw new SemRetornoException();
    }
}
