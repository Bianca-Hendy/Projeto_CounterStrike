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
public class Arma extends Artefato{
    private String descrição;
    private Tipo nivelA;

    public Arma() {
    }

    /**
     * @return the descrição
     */
    public String getDescrição() {
        return descrição;
    }

    /**
     * @param descrição the descrição to set
     */
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    /**
     * @return the nivelA
     */
    public Tipo getNivelA() {
        return nivelA;
    }

    /**
     * @param nivelA the nivelA to set
     */
    public void setNivelA(Tipo nivelA) {
        this.nivelA = nivelA;
    }
    
}
