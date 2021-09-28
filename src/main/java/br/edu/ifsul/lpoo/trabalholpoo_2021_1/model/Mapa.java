/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model;

import java.io.Serializable;

/**
 *
 * @author bianca.evangelista
 */
public class Mapa implements Serializable{
    private Integer id;
    private String nome;
    private Local locais;
    
    public Mapa() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the locais
     */
    public Local getLocais() {
        return locais;
    }

    /**
     * @param locais the locais to set
     */
    public void setLocais(Local locais) {
        this.locais = locais;
    }
    
}
