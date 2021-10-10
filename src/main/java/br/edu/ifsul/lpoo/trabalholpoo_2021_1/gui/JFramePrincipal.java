/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui;

import br.edu.ifsul.lpoo.trabalholpoo_2021_2.Controle;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author bianca.evangelista
 */


public class JFramePrincipal extends JFrame implements WindowListener {
    
    
    public Controle controle;
    public CardLayout cardLayout;
    public JPanel paineldeFundo;

    
    public JFramePrincipal(Controle controle){
        
        this.controle = controle;
        
        initComponents();
    }
    
    private void initComponents(){
                
        this.setTitle("JOGO COUNTER STRIKE");//seta o título
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // por padrão abre maximizado.        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );// finaliza o processo quando o frame é fechado.            
        this.addWindowListener(this);//adiciona o listener no frame
        
        cardLayout = new CardLayout();//iniciando o gerenciador de layout para esta JFrame
        paineldeFundo = new JPanel();//inicializacao
        paineldeFundo.setLayout(cardLayout);//definindo o cardLayout para o paineldeFundo

        this.add(paineldeFundo);
    }
    
    public void addTela(JPanel painel, String nome){   
        paineldeFundo.add(painel, nome);
    }

    public void showTela(String nome){
        cardLayout.show(paineldeFundo, nome);
    }


    @Override
    public void windowOpened(WindowEvent e) {        
    }

    @Override
    public void windowClosing(WindowEvent e) {
                
        controle.fecharBD();
    }

    @Override
    public void windowClosed(WindowEvent e) {        
    }

    @Override
    public void windowIconified(WindowEvent e) {        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {        
    }

    @Override
    public void windowActivated(WindowEvent e) {        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {        
    }
    
}

