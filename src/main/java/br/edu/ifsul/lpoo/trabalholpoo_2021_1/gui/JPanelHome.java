/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui;
import br.edu.ifsul.lpoo.trabalholpoo_2021_2.Controle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author bianca.evangelista
 */
public class JPanelHome extends JPanel {
    
    private JLabel lblMensagem;
    private JLabel lblData;
    private JLabel lblImagem;
    private BorderLayout layoutGeo;
    
    private Controle controle;
    
    public JPanelHome(Controle controle){
        
        this.controle = controle;
        initComponents();
    }
    
    private void initComponents(){
        
        layoutGeo = new BorderLayout();
        this.setLayout(layoutGeo);//seta o gerenciador de layout para este painel.
        
        lblMensagem = new JLabel("Tela de Boas Vindas ao Jogo C.S!");
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblMensagem, BorderLayout.NORTH);
                
        lblImagem = new JLabel(new ImageIcon(JPanelHome.class.getResource("/images/cs1.jpg")));
        this.add(lblImagem, BorderLayout.CENTER);//adiciona a imagem na parte central deste painel.
        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");       
        
        lblData = new JLabel(df.format(c.getTime()));
        lblData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblData.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblData, BorderLayout.SOUTH); //adiciona o rotulo para a data na parte inferior deste painel.       
        
    }
}

