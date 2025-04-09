package jlucas.primeiro_projeto.application.serviceimpl;

import jlucas.primeiro_projeto.application.service.UserServiceInterface;
import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.domain.usecase.user.AtualizarUserCase;
import jlucas.primeiro_projeto.domain.usecase.user.ConsultarUserCase;
import jlucas.primeiro_projeto.domain.usecase.user.DeleteUserCase;
import jlucas.primeiro_projeto.domain.usecase.user.InserirUserCase;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface
{
    @Autowired
    private ConsultarUserCase consultarUserCase;
    @Autowired
    private DeleteUserCase deleteUserCase;
    @Autowired
    private InserirUserCase inserirUserCase;
    @Autowired
    private AtualizarUserCase atualizarUserCase;
    public UserServiceImpl(ConsultarUserCase consultarUserCase)
    {
        this.consultarUserCase = consultarUserCase;
    }

    @Override
    public List<User> consultaUserAtivo() throws SemRetornoException {

        return consultarUserCase.buscaUserAtivos();
    }
    @Override
    public User consultarUserId(Integer id) throws SemRetornoException
    {
        Optional<User> user = consultarUserCase.buscarUserId(id);
        if (user.isPresent())
        {
            return user.get();
        }else {
            throw new SemRetornoException();
        }
    }
    @Override
    public User consultarUserNome(String nome) throws SemRetornoException {
        Optional<User> user = consultarUserCase.buscarNome(nome);
        if (user.isPresent())
        {
            return user.get();
        }else {
            throw new SemRetornoException();
        }
    }

    @Override
    public User consultarEmail(String email) throws SemRetornoException
    {
        User user = consultarUserCase.buscarEmail(email);
        if(user == null)
        {
            throw new SemRetornoException();
        }
        return user;
    }
    @Override
    public void apagaUser(Integer id) throws SemRetornoException {
        deleteUserCase.deleteUser(id);
    }

    @Override
    public User inserirUser(User user) throws SemRetornoException
    {
        inserirUserCase.inserirUser(user);
        return user;
    }

    public User atualizarUser(Integer id,User user) throws SemRetornoException
    {
        atualizarUserCase.atualizarUser(id,user);
        return user;
    }

}
