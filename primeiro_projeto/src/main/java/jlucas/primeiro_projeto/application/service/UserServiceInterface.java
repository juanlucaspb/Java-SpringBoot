package jlucas.primeiro_projeto.application.service;

import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;

import java.util.List;

public interface UserServiceInterface
{
    public List<User> consultaUserAtivo() throws SemRetornoException;
    public User consultarUserId(Integer id) throws SemRetornoException;
    public void apagaUser(Integer id) throws SemRetornoException;

    User consultarUserNome(String nome) throws SemRetornoException;

    public User consultarEmail(String email) throws  SemRetornoException;
    public  User inserirUser(User user) throws  SemRetornoException;
    public User atualizarUser(Integer id,User user) throws SemRetornoException;

}
