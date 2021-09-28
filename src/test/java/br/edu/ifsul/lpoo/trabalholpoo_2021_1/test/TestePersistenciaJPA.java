/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.test;

//import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao.PersistenciaJPA;
import org.junit.Test;

/**
 *
 * @author bianca.evangelista
 */
public class TestePersistenciaJPA {
    @Test 
    public void testarConexao() throws Exception {

        PersistenciaJPA persistencia = new PersistenciaJPA();

        if (persistencia.conexaoAberta()) {

            System.out.println("Conexão com o BD aberta utilizando JPA");
            persistencia.fecharConexao();

        } else {

            System.out.println("Não houve conesão via JPA");
        }
    }
    
    //@Test
    public void testarPersistenciaJogador() throws Exception{
                
        PersistenciaJPA persistencia = new PersistenciaJPA();
        
        if(persistencia.conexaoAberta()){
                        
            Jogador j = (Jogador)persistencia.find(Jogador.class, new String("Joaozito"));
            
            if(j == null){
                
                //nao existe registro na tabela tb_pais com o id=2
                System.out.println("Não encontrou o jogador na tb_jogador");
                
                j = new Jogador();
                j.setSenha("1234");
                j.setPontos(10000);
                                
                persistencia.persist(j); //insert
                
                System.out.println("Inseriu o jogador : "+j.getNickname()+"\n Senha: "+j.getSenha()+"\n Pontos: "+j.getPontos());
                
            }else{
                
                //existe registro na tabela
                System.out.println("Jogador: "+j.getNickname());
                System.out.println("Pontos do jogador: "+j.getPontos());
                
                j.setNickname("Marcia");
                
                persistencia.persist(j); //update
                
                
                System.out.println("Alterou o registro para : "+j.getNickname());
                
                
                //persistencia.remover(p);                                
                //System.out.println("REmoveu o p: "+p.getId());                                
                
            }            
                        
            System.out.println("Conexao com o BD aberta utilizando JPA");
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Não abriu conexao via jpa");
        }
    } 
}
