/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.jogador;

import br.edu.ifsul.lpoo.trabalholpoo_2021_2.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author bianca.evangelista
 */
public class JPanelJogador extends JPanel {
    
    private Controle controle;
    private CardLayout layoutCard;
    
    private JPanelListagem telaListagem;
    private JPanelEdicao telaEdicao;
    
    
    public JPanelJogador(Controle controle){
        
        this.controle = controle;
        
        initComponents();
    }
    
    private void initComponents(){
        
        layoutCard = new CardLayout();//inicializa o gerenciador de layout.
        this.setLayout(layoutCard);//defini o gerenciador de layout para este painel.
        
        telaListagem = new JPanelListagem(this, controle);
        telaEdicao = new JPanelEdicao(this, controle);
        
        this.add(getTelaListagem(), "tela_listagem"); // adiciona uma carta
        this.add(telaEdicao, "tela_edicao");     // adiciona a segunda carta no baralho.        
        
        layoutCard.show(this, "tela_listagem"); //por padrão mostra o painel de listagem
    }

    public JPanelListagem getTelaListagem() {
        return telaListagem;
    }
    
    
    
}

