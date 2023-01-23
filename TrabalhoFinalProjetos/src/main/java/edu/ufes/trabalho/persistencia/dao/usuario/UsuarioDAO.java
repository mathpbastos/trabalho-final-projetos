package edu.ufes.trabalho.persistencia.dao.usuario;

import edu.ufes.trabalho.model.Usuario;
import edu.ufes.trabalho.persistencia.conexao.ConexaoSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private Connection conexao = null;
    private final DateTimeFormatter formatador
            = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    @Override
    public boolean salvar(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO usuarios ("
                    + "nm_usuario" //1
                    + ", login" //2
                    + ", senha" //3
                    + ", dt_cadastro" //4
                    + ", dt_modificacao"//5
                    + ", fl_autorizacao"//6
                    + ", fl_administrador) "//7
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?);";

            ps = conexao.prepareStatement(query);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            /*
            Como o Sqlite utiliza strings para armazenar datas, realizamos a 
            conversão da data atual para string.
             */
            ps.setString(4,
                    formatador.format(LocalDate.now()));
            ps.setString(5,
                    formatador.format(LocalDate.now()));
            ps.setBoolean(6, false); // false pois deve ser o padao ao ser cadastrado
            ps.setBoolean(7, usuario.isAdministrador());
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao cadastrar usuário."
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps);
        }
    }

    @Override
    public boolean atualizar(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE usuarios "
                    + "SET "
                    + "nm_usuario = ?"//1
                    + ", login = ?" //2
                    + ", senha = ?"//3
                    + ", dt_modificacao = ? " //4
                    + ", fl_autorizacao = ?"//5
                    + ", fl_administrador = ? " //6
                    + "WHERE id_usuario = ?;"; //7

            ps = conexao.prepareStatement(query);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, formatador
                    .format(LocalDate.now()));
            ps.setBoolean(5, usuario.isAutorizado());
            ps.setBoolean(6, usuario.isAdministrador());
            ps.setLong(7, usuario.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            throw new SQLException("Erro ao atualizar informações do usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps);
        }
    }

    @Override
    public Usuario buscarPorId(long id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT "
                    + "nm_usuario"//1
                    + ", login"//2
                    + ", senha"//3
                    + ", dt_cadastro"//4
                    + ", dt_modificacao"//5
                    + ", fl_autorizacao"//6
                    + ", fl_administrador "//7
                    + "FROM usuarios "
                    + "WHERE id_usuario = ?;"; // 1
            ps = conexao.prepareStatement(query);
            ps.setLong(1, id);

            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Usuário com id " + id
                        + " não encontrado.");
            }
            String nome = rs.getString(1);
            String login = rs.getString(2);
            String senha = rs.getString(3);
            LocalDate dtCadastro = LocalDate.parse(rs.getString(4),
                    formatador);
            LocalDate dtModificacao = LocalDate.parse(rs.getString(5),
                    formatador);
            // O valor 1, indica flag true no SGBD
            boolean autorizacao = rs.getInt(6) == 1;

            boolean administrador = rs.getInt(7) == 1;
            return new Usuario(id,
                    nome,
                    login,
                    senha,
                    dtCadastro,
                    dtModificacao,
                    administrador,
                    autorizacao);
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar o usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps, rs);
        }
    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT "
                    + "id_usuario"//1
                    + ", nm_usuario"//2
                    + ", login"//3
                    + ", senha"//4
                    + ", dt_cadastro"//5
                    + ", dt_modificacao"//6
                    + ", fl_autorizacao"//7
                    + ", fl_administrador "//8
                    + "FROM usuarios;";
            ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Não há funcionários cadastrados.\n");
            }

            List<Usuario> usuarios = new ArrayList<Usuario>();

            do {
                long id = rs.getLong(1);
                String nome = rs.getString(2);
                String login = rs.getString(3);
                String senha = rs.getString(4);
                LocalDate dataCadastro = LocalDate
                        .parse(rs.getString(5), formatador);
                LocalDate dataModificacao = LocalDate
                        .parse(rs.getString(6), formatador);
                // O valor 1, indica flag true no SGBD
                boolean autorizacao = rs.getInt(7) == 1;

                boolean administrador = rs.getInt(8) == 1;

                usuarios.add(new Usuario(id,
                        nome,
                        login,
                        senha,
                        dataCadastro,
                        dataModificacao,
                        administrador,
                        autorizacao));
            } while (rs.next());

            return usuarios;

        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar os usuários cadastrados.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps, rs);
        }
    }

    @Override
    public boolean excluir(long id) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM "
                    + "usuarios "
                    + "WHERE id_usuario = ?;";//1
            ps = conexao.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            throw new SQLException("Erro durante exclusão do usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps);
        }
    }

    @Override
    public Usuario autenticar(String login, String senha) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT "
                    + "id_usuario"//1
                    + ", nm_usuario"//2
                    + ", dt_cadastro"//3
                    + ", dt_modificacao"//4
                    + ", fl_autorizacao"//5
                    + ", fl_administrador "//6
                    + "FROM usuarios"
                    + "WHERE login = ? "
                    + "AND senha = ?;";
            ps = conexao.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Não foi possível autenticar o usuário.\n"
                        + "Favor verificar login e senha informados.");
            }
            long id = rs.getLong(1);
            String nome = rs.getString(2);
            LocalDate dataCadastro = LocalDate
                    .parse(rs.getString(3), formatador);
            LocalDate dataModificacao = LocalDate
                    .parse(rs.getString(4), formatador);

            // O valor 1, indica flag true no SGBD
            boolean autorizacao = rs.getInt(5) == 1;
            if (!autorizacao) {
                throw new RuntimeException("O usuário para as credenciais "
                        + "informadas não está autorizado a logar nesse sistema.");
            }

            boolean administrador = rs.getInt(6) == 1;

            return new Usuario(id,
                    nome,
                    login,
                    senha,
                    dataCadastro,
                    dataModificacao,
                    administrador,
                    autorizacao);
        } catch (SQLException ex) {
            throw new SQLException("Erro ao realizar autenticação "
                    + "do usuário.\n" + ex.getMessage());
        } finally {
            ConexaoSQLite.fecharConexao(conexao, ps, rs);
        }
    }

}
