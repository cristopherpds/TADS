package com.ExemploAula.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="categoria")
public class CategoriaModel implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@NotBlank
private String descricao;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

}
