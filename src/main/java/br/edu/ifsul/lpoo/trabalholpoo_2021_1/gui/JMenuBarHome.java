/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui;

import br.edu.ifsul.lpoo.trabalholpoo_2021_2.Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author bianca.evangelista
 */
public class JMenuBarHome extends JMenuBar implements ActionListener {
    
    private JMenu menuArquivo;
    private JMenuItem menuItemSair;
    
    private JMenu menuCadastro;
    private JMenuItem menuItemUsuario;    
    
    private Controle controle;
    
    public JMenuBarHome(Controle controle){
        
        this.controle = controle;        
        
        initComponents();
    }
    
    private void initComponents(){
        
        menuArquivo = new JMenu("Arquivo");
            menuItemSair = new JMenuItem("Sair");
            menuItemSair.addActionListener(this);
            menuItemSair.setActionCommand("menu_sair");
        menuArquivo.add(menuItemSair);
        
        menuCadastro = new JMenu("Cadastros");
            menuItemUsuario = new JMenuItem("Usuário");
            menuItemUsuario.addActionListener(this);
            menuItemUsuario.setActionCommand("menu_usuario");
        menuCadastro.add(menuItemUsuario);   
        
        this.add(menuArquivo);
        this.add(menuCadastro);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
                
        if(e.getActionCommand().equals(menuItemSair.getActionCommand())){
        
            //se o usuario clicou no menuitem Sair
            int d = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do jogo? ", "Sair", JOptionPane.YES_NO_OPTION);
            if(d == 0){                
                controle.fecharBD();//fecha a conexao com o banco de dados.
                System.exit(0);//finaliza o processo do programa.
            }
            
            
        }else if(e.getActionCommand().equals(menuItemUsuario.getActionCommand())){
            
            //se o usuario clicou no menuitem Usuario            
            controle.showTela("tela_usuario");            
        }
        
    }
}

