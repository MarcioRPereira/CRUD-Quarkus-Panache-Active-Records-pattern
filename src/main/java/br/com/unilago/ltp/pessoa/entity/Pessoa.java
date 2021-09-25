package br.com.unilago.ltp.pessoa.entity;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity{

    public String nome;

    public String cpf;

    public int idade;
    
}