package jlucas.primeiro_projeto.domain.usecase.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InserirUserCase
{
    private static final Logger logger = LoggerFactory.getLogger(InserirUserCase.class);
    @Autowired
    private UserRepository userRepository;

    public User inserirUser(User user)
    {
        String senhaCriptografada = BCrypt.withDefaults().hashToString(12, user.getSenha().toCharArray());
        user.setSenha(senhaCriptografada);
        return userRepository.save(user);
    }
}

