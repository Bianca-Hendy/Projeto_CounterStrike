/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model;

/**
 *
 * @author bianca.evangelista
 */
public class Municao extends Artefato{
    
    private String descricao;
    private Integer qtdPente;
    private Calibre tam;

    public Municao() {
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the qtdPente
     */
    public Integer getQtdPente() {
        return qtdPente;
    }

    /**
     * @param qtdPente the qtdPente to set
     */
    public void setQtdPente(Integer qtdPente) {
        this.qtdPente = qtdPente;
    }

    /**
     * @return the tam
     */
    public Calibre getTam() {
        return tam;
    }

    /**
     * @param tam the tam to set
     */
    public void setTam(Calibre tam) {
        this.tam = tam;
    }
   
    
}
