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
public class Local implements Serializable{
    private Integer id;
    private String nome;
    private String Latitude;
    private String longitute;

    public Local() {
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
     * @return the Latitude
     */
    public String getLatitude() {
        return Latitude;
    }

    /**
     * @param Latitude the Latitude to set
     */
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    /**
     * @return the longitute
     */
    public String getLongitute() {
        return longitute;
    }

    /**
     * @param longitute the longitute to set
     */
    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }
}
