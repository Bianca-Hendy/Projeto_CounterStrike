/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_2;

import javax.swing.JOptionPane;

/**
 *
 * @author bianca.evangelista
 */
public class Trabalho_2021_2 {
    
    private Controle controle;
    
    public Trabalho_2021_2 (){
        //construtor da classe
        
        controle = new Controle();
        
        if(controle.conectarBD()){
                        
            controle.initComponents();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Não conectou no Banco de Dados!", "Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        
    } 
    
    public static void main(String[] args){
        
        new Trabalho_2021_2();
    }
    
}

