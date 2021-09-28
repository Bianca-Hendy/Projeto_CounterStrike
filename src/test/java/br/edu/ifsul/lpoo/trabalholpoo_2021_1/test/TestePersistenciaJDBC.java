/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.test;

import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Artefato;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao.PersistenciaJDBC;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author bianca.evangelista
 */
public class TestePersistenciaJDBC {

    //@Test
    public void testarConexao() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            System.out.println("Conexao com o BD aberta utilizando JDBC");
            persistencia.fecharConexao();

        } else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }

    @Test
    public void testarPersistenciaJogador() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {
            Jogador jogador = (Jogador) persistencia.find(Jogador.class, new String("Fulano"));
            //System.out.println("Insere jogador");
            if (jogador == null) {
                jogador = new Jogador();
                jogador.setNickname("bianca");
                jogador.setSenha("ddd");
                jogador.setData_cadastro(Date.valueOf(LocalDate.parse("2020-08-21")));
                jogador.setData_ultimo_login(Date.valueOf(LocalDate.parse("2021-07-21")));
                jogador.setPontos(1000);

                persistencia.persist(jogador);

                System.out.println("Inseriu o Jogador " + jogador.getNickname() + "\nPontos: " + jogador.getPontos());
            }
            //persistencia.fecharConexao();

        } else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }

    //@Test
    public void testarPersistenciaArtefato() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            Artefato a = (Artefato) persistencia.find(Artefato.class, new Integer(1));
            //
            if (a == null) {

                System.out.println("Nao encontrou o artefato id = 1");

                a = new Artefato();

                a.setNome("Arma");
                a.setValor(350.0);

                persistencia.persist(a);

                System.out.println("Artefato: " + a.getNome());

            } else {

                System.out.println("Encontrou o artefato: " + a.getNome() + "\nValor: " + a.getValor());

                a.setNome("Taco de beisebol");
                a.setValor(35.0);

            }
            persistencia.fecharConexao();

        } else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }

   //@Test
    public void testarPersistenciaJogadorA() throws Exception {

        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            System.out.println("Conexao com o BD aberta utilizando JDBC");

            List<Jogador> lista = persistencia.getJogadores();
            if (lista != null && !lista.isEmpty()) {

                for (Jogador jog : lista) {

                    System.out.println("Jogador encontrado : " + jog.getNickname() + "\nPontos : " + jog.getPontos());

                    if (jog.getArtefatos() != null && !jog.getArtefatos().isEmpty()) {

                        for (Artefato a : jog.getArtefatos()) {

                            System.out.println(" Artefato " + a.getId());
                        }
                    }

                   // persistencia.remover(jog);

                }

            } else {

                Jogador j = new Jogador();

                j.setNickname("Fulano");
                j.setSenha("ddd");
                j.setData_cadastro(Date.valueOf(LocalDate.parse("2020-08-21")));
                j.setData_ultimo_login(Date.valueOf(LocalDate.parse("2021-07-21")));
                j.setPontos(1000);

                Artefato p1 = (Artefato) persistencia.find(Artefato.class, new Integer(1));

                j.setArtefato(p1);

                persistencia.persist(j);

            }

            persistencia.fecharConexao();

        } else {
            System.out.println("Não abriu conexao via JDBC");
        }

    }

}
