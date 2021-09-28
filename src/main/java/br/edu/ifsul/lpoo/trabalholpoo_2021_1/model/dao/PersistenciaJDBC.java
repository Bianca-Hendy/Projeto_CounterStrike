/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.dao;

import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Artefato;
import br.edu.ifsul.lpoo.trabalholpoo_2021_1.model.Jogador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bianca.evangelista
 */
public class PersistenciaJDBC implements InterfacePersistencia {

    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "1234";
    public static final String URL = "jdbc:postgresql://localhost:5432/pu.db.br.edu.ifsul.TrabalhoLPOO_2021_1";
    private Connection con = null;

    public PersistenciaJDBC() {

        try {

            Class.forName(DRIVER); //carregamento do driver postgresql em tempo de execução
            System.out.println("Tentando estabelecer conexao JDBC com : " + URL);
            this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public Boolean conexaoAberta() {
        try {
            if (con != null) {
                return !con.isClosed();//verifica se a conexao está aberta
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void fecharConexao() {
        try {
            this.con.close();//fecha a conexao.
            System.out.println("Fechou conexao JDBC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param c
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Object find(Class c, Object id) throws Exception {
        if (c == Jogador.class) {
            Jogador jogador = null;

            // executar um select em tb_jogador
            PreparedStatement ps = this.con.prepareStatement("select g.nickname, g.senha, g.data_cadastro, g.data_ultimo_login, g.pontos "
                    + " from tb_jogador g where g.nickname = ? ");
            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();//executa a query
            if (rs.next()) {

                jogador = new Jogador();//inicialização do objeto que será retornado.
                jogador.setNickname(rs.getString("nickname"));
                jogador.setSenha(rs.getString("senha"));
                jogador.setData_cadastro(rs.getDate("data_cadastro"));
                jogador.setData_ultimo_login(rs.getDate("data_ultimo_login"));
                jogador.setPontos(rs.getInt("pontos"));
                ps.close();//fecha o cursor

                // executar um select envolvendo tb_artefatos e tb_artefato.
                ps = this.con.prepareStatement("select pm.id, pm.nome, pm.valor from tb_artefatos ps, tb_artefato pm "
                        + " where ps.artefato_id = pm.id and  ps.jogador_nickname = ? ");
                ps.setString(1, jogador.getNickname());

                rs = ps.executeQuery();
                while (rs.next()) {

                    Artefato a = new Artefato();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setValor(rs.getDouble("valor"));

                    jogador.setArtefato(a);//adiciona no jogador o artefato                    
                }
                rs.close();//fecha o cursor
                ps.close();//fecha
            }
            return jogador;

        } else if (c == Artefato.class) {

            PreparedStatement ps = this.con.prepareStatement("select a.id, a.nome, a.valor from tb_artefato a "
                    + "where id = ? ");

            ps.setInt(1, Integer.parseInt(id.toString()));

            ResultSet rs = ps.executeQuery();//o ponteiro do REsultSet inicialmente está na linha -1

            if (rs.next()) {//se a matriz (ResultSet) tem uma linha

                Artefato art = new Artefato();
                art.setId(rs.getInt("id"));
                art.setNome(rs.getString("nome"));
                art.setValor(rs.getDouble("valor"));

                return art;
            }

        }
        return null;
    }

    @Override
    public void persist(Object o) throws Exception {
        
        if (o instanceof Jogador) {

            Jogador j = (Jogador) o;//conversao

            if (j.getNickname() == null) {

                //prepara a instrução.
                PreparedStatement ps = this.con.prepareStatement("insert into tb_jogador(nickname, senha, data_cadastro, data_ultimo_login, pontos)"
                        + "values(nextval('seq_jogador_nickname'),?,?,?,?)");

                ps.setString(1, j.getSenha());
                ps.setDate(2, j.getData_cadastro());
                ps.setDate(3, j.getData_ultimo_login());
                ps.setInt(4, j.getPontos());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    j.setNickname(rs.getString("nickname"));

                    if (j.getArtefatos() != null && j.getArtefatos().size() > 0) {

                        for (Artefato p : j.getArtefatos()) {

                            ps = this.con.prepareStatement("insert into tb_artefatos (jogador_nickname, artefato_id) values (?, ?)");
                            ps.setString(1, j.getNickname());
                            ps.setInt(2, p.getId());
                            //insert em tb_artefatos
                            ps.execute();
                        }
                    }
                }
                rs.close();//fecha o cursor
                ps.close();
            } else {

                PreparedStatement ps = this.con.prepareStatement("update tb_jogador set senha = ?, data_cadastro = ?, data_ultimo_login = ?, pontos = ? where nickname = ? "); //prepara a instrução
                ps.setString(1, j.getSenha());
                ps.setDate(2, j.getData_cadastro());
                ps.setDate(3, j.getData_ultimo_login());
                ps.setInt(4, j.getPontos());

                ps = this.con.prepareStatement("delete from tb_artefatos where jogador_nickname = ? ");
                ps.setString(1, j.getNickname());

                /*if (j.getArtefatos() != null && j.getArtefatos().size() > 0) {

                    for (Artefato p : j.getArtefatos()) {

                        ps = this.con.prepareStatement("insert into tb_artefatos (jogador_nickname, artefato_id) values (?, ?)");
                        ps.setString(1, j.getNickname());
                        ps.setInt(2, p.getId());

                        //insert em tb_artefatos
                        ps.execute();
                    }
                    ps.close();
                }*/
            }
        } else if (o instanceof Artefato) {
            Artefato a = (Artefato) o;

            if (a.getId() == null) {

                PreparedStatement ps = this.con.prepareStatement("insert into tb_artefato (id, nome, valor) values (nextval('seq_artefato_id'),?,?)");
                ps.setString(1, a.getNome());
                ps.setDouble(2, a.getValor());
                ps.execute();

                ps.close();

            } else {
                PreparedStatement ps = this.con.prepareStatement("update into tb_artefato (id, nome, valor) values (nextval('seq_artefato_id'),?,?)");
                ps.setString(1, a.getNome());
                ps.setDouble(2, a.getValor());
                ps.execute();
            }
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        if (o instanceof Jogador) {

            //delete em tb_artefatos
            Jogador jogador = (Jogador) o;
            PreparedStatement ps = this.con.prepareStatement("delete from tb_artefatos where jogador_nickname = ? ");
            ps.setString(1, jogador.getNickname());
            ps.execute();

            //delete em tb_jogador.
            ps = this.con.prepareStatement("delete from tb_jogador where nickname = ? ");
            ps.setString(1, jogador.getNickname());
            /*ps.setString(1, jogador.getSenha());
                ps.setDate(2, jogador.getData_cadastro());
                ps.setDate(3, jogador.getData_ultimo_login());
              ps.setInt(4, jogador.getPontos());*/
            ps.execute();

            ps.close();
        }
    }

    @Override
    public Jogador doLogin(String nickname, String senha) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Jogador> getJogadores() throws Exception {

        List<Jogador> lista = null;

        // executar um select em tb_jogador
        PreparedStatement ps
                = this.con.prepareStatement("select p.nickname, p.senha, p.pontos "
                        + " from tb_jogador p "
                        + " order by p.nickname asc ");
        ResultSet rs = ps.executeQuery();//executa a query

        lista = new ArrayList();

        while (rs.next()) {

            Jogador jog = new Jogador();//inicialização do objeto que será retornado.
            jog.setNickname(rs.getString("nickname"));
            jog.setPontos(rs.getInt("pontos"));

            // executar um select envolvendo tb_artefatos e tb_artefato.
            PreparedStatement ps2 = this.con.prepareStatement("select pm.id, pm.nome, pm.valor "
                    + " from tb_artefatos ps, tb_artefato pm "
                    + " where ps.artefato_id=pm.id and  ps.jogador_nickname = ? ");
            ps2.setString(1, jog.getNickname());

            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {

                Artefato art = new Artefato();
                art.setId(rs2.getInt("id"));
                art.setNome(rs2.getString("nome"));
                art.setValor(rs2.getDouble("valor"));

                jog.setArtefato(art);//adiciona no jogador o artefato                    
            }
            rs2.close();//fecha o cursor
            ps2.close();//fecha

            lista.add(jog);
        }

        rs.close();
        ps.close();//fecha o cursor

        return lista;
    }

}
