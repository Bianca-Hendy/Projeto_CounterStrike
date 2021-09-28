/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao;

import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;

/**
 *
 * @author bianca.evangelista
 */
public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    
    public void fecharConexao();
    
    public Object find(Class c, Object id) throws Exception;
    
    public void persist(Object o) throws Exception;
    
    public void remover(Object o) throws Exception;
    
    public Jogador doLogin(String nickname, String senha) throws Exception;
}
