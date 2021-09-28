/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "tb_itenscompra")
public class ItensCompra implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_itenscompra", sequenceName = "seq_itenscompra_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itenscompra", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private Integer quantidade;
    
    @Column(precision = 2)
    private Float valor;
    
    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compras;
    
    @ManyToOne    
    @JoinColumn(name = "artefato_id", nullable = true)
    private Artefato artefato;

    public ItensCompra() {
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
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the compras
     */
    public Compra getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(Compra compras) {
        this.compras = compras;
    }

    /**
     * @return the artefato
     */
    public Artefato getArtefato() {
        return artefato;
    }

    /**
     * @param artefato the artefato to set
     */
    public void setArtefato(Artefato artefato) {
        this.artefato = artefato;
    }
     
}
