package jlucas.primeiro_projeto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User
{
    @Id
    @JsonIgnore
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private  String nome;

    @Column(name = "email", nullable = false, unique = true)
    private  String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "status", nullable = false)
    private Integer status;

}
