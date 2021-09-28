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
public class Resultado implements Serializable{
    private Calendar data;
    private Round roundId;
    private Status status;
    private Round round;
    private Objetivo obj;

    public Resultado() {
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the roundId
     */
    public Round getRoundId() {
        return roundId;
    }

    /**
     * @param roundId the roundId to set
     */
    public void setRoundId(Round roundId) {
        this.roundId = roundId;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the round
     */
    public Round getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(Round round) {
        this.round = round;
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
