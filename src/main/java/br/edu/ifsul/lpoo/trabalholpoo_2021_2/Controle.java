/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_2;

import br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.JFramePrincipal;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.JMenuBarHome;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.JPanelHome;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.autenticação.JPanelAutenticacao;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.gui.jogador.JPanelJogador;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao.PersistenciaJDBC;
import javax.swing.JOptionPane;

/**
 *
 * @author bianca.evangelista
 */
public class Controle {
    
    private PersistenciaJDBC conexaoJDBC;
    private JFramePrincipal frame;
    private JPanelAutenticacao pnlAutenticacao;
    private JMenuBarHome menuBar;
    private JPanelHome pnlHome;
    private JPanelJogador pnlJogador;
    
    public Controle(){
        
    }
    
    public void initComponents(){
        
        frame = new JFramePrincipal(this);
        
        pnlAutenticacao = new JPanelAutenticacao(this);
        
        menuBar = new JMenuBarHome(this);
        
        pnlHome = new JPanelHome(this);
        
        pnlJogador = new JPanelJogador(this);
        
        frame.addTela(pnlAutenticacao, "tela_autenticacao");//carta 1
        frame.addTela(pnlHome, "tela_home");//carta 2
        frame.addTela(pnlJogador, "tela_usuario");//carta 3
        
        frame.showTela("tela_autenticacao");
        
        frame.setVisible(true); // torna visível o jframe
    }
    
    public boolean conectarBD(){
        
        conexaoJDBC = new PersistenciaJDBC();
        
        if(getConexaoJDBC() != null){
            
            return getConexaoJDBC().conexaoAberta();
        }
        
        return false;
    }
    
    public void fecharBD(){
        
        System.out.println("Fechando conexao com o Banco de Dados");
        getConexaoJDBC().fecharConexao();
        
    }
    
    public void showTela(String nomeTela){
        
        if(nomeTela.equals("tela_usuario")){
         
            pnlJogador.getTelaListagem().populaTable();
        }
        
        frame.showTela(nomeTela);
    }
    
    public void autenticar(String nickname, String senha) {
        
        try{
            
            Jogador jog =  getConexaoJDBC().doLogin(nickname, senha);
            if(jog != null){
                
                JOptionPane.showMessageDialog(pnlAutenticacao, "Usuario "+jog.getNickname()+" autenticado com sucesso!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
                
                frame.setJMenuBar(menuBar);//adiciona o menu de barra no frame
                frame.showTela("tela_home");//muda a tela para o painel de boas vindas (home)
                
            }else{
                
                JOptionPane.showMessageDialog(pnlAutenticacao, "Dados inválidos!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(pnlAutenticacao, "Erro ao executar a autenticação no Banco de Dados!", "Autenticação", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }
}

    