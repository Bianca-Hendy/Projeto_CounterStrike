/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author bianca.evangelista
 */
public class Round implements Serializable{
    private Integer id;
    private Calendar data_inicio;
    private Calendar data_fim;
    private Modo modo;
    private Objetivo obj;
    
    public Round() {
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
     * @return the data_inicio
     */
    public Calendar getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return the data_fim
     */
    public Calendar getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(Calendar data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * @return the modo
     */
    public Modo getModo() {
        return modo;
    }

    /**
     * @param modo the modo to set
     */
    public void setModo(Modo modo) {
        this.modo = modo;
    }

    /**
     * @return the obj
     */
    public Objetivo getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Objetivo obj) {
        this.obj = obj;
    }
    
    
}
