package jlucas.primeiro_projeto.domain.repository;

import jlucas.primeiro_projeto.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{

    /**
     *  <h5>Status: </h5>
     *  <ul>
     *      <li> 0 - Inativo</li>
     *      <li>1 - Ativo</li>
     *  </ul>
     *
     *
     * @param status
     * @return List<User>
     */

    public List<User> findByStatus(Integer status);
    public Optional<User> findById(Integer id);
    public  User findByEmail(String email);
    public  Optional<User> findByNomeContaining(String nome); //Marian //Mariana



}
