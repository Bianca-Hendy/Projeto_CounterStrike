/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao;


import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bianca.evangelista
 */
public class PersistenciaJPA implements InterfacePersistencia{
    
    public EntityManagerFactory factory;
    public EntityManager entity;
    
    
     public PersistenciaJPA(){        
        factory = Persistence.createEntityManagerFactory("pu.br.edu.ifsul.TrabalhoLPOO_2021_1");
        entity = factory.createEntityManager();        
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();//se estiver aberto retorna verdadeiro, caso contrario retorna falso
    }

    @Override
    public void fecharConexao() {
        entity.close();
        
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        
        entity.getTransaction().begin();//abre transacao
        entity.persist(o);//persiste (update ou insert)
        entity.getTransaction().commit();//commit na transacao
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();//abre transacao
        entity.remove(o);//persiste (update ou insert)
        entity.getTransaction().commit();//commit na transacao}
    }

    @Override
    public Jogador doLogin(String nickname, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
