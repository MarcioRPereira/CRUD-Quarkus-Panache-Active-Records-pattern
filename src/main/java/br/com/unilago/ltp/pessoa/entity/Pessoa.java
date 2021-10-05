package br.com.unilago.ltp.pessoa.entity;

import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity{

    public String nome;

    public String cpf;

    public int idade;

    public static List<Pessoa> findByName(String nome){
        return find("nome", nome).list();
    }
    
}