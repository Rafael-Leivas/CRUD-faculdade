import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

public class MatriculaStore {

    //Comando para rodar
    //java -cp ".;./mysql-connector-j-8.2.0.jar" TodoApp

    public static void inserir(Matricula matricula) {
        String query = "INSERT INTO matricula (nome, anosCompletos, email, endereco, cep, telefone, usuario, senha, curso, observacao, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement  stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBanco.getConexao();

            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, matricula.getNome());
            stmt.setInt(2, matricula.getAnosCompletos());
            stmt.setString(3, matricula.getEmail());
            stmt.setString(4, matricula.getEndereco());
            stmt.setString(5, matricula.getCep());
            stmt.setString(6, matricula.getTelefone());
            stmt.setString(7, matricula.getUser());
            stmt.setString(8, matricula.getPassword());
            stmt.setString(9, matricula.getCurso());
            stmt.setString(10, matricula.getObservacao());
            stmt.setBoolean(11, matricula.getAtivo());
            stmt.execute();

            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                matricula.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editar(Matricula matricula) {
        String query = "UPDATE matricula SET nome = ?, anosCompletos = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacao = ?, ativo = ? WHERE id = ?";
    
        Connection conn = null;
        PreparedStatement  stmt = null;

        try{
            conn = ConexaoBanco.getConexao();

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, matricula.getId());
            stmt.setString(2, matricula.getNome());
            stmt.setInt(3, matricula.getAnosCompletos());
            stmt.setString(4, matricula.getEmail());
            stmt.setString(5, matricula.getEndereco());
            stmt.setString(6, matricula.getCep());
            stmt.setString(7, matricula.getTelefone());
            stmt.setString(8, matricula.getUser());
            stmt.setString(9, matricula.getPassword());
            stmt.setString(10, matricula.getCurso());
            stmt.setString(11, matricula.getObservacao());
            stmt.setBoolean(12, matricula.getAtivo());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remover(Matricula matricula) {
        String query = "DELETE FROM matricula WHERE id = ?";

        Connection conn = null;
        PreparedStatement  stmt = null;

        try{
            conn = ConexaoBanco.getConexao();

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, matricula.getId());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Matricula> listar() {
        ArrayList<Matricula> matriculas = new ArrayList<>();

        String query = "SELECT id, nome, anosCompletos, email, endereco, cep, telefone, usuario, senha,curso,observacao,ativo FROM matricula";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            //TODO: Conectar

            conn = ConexaoBanco.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setId(rs.getInt("id"));
                matricula.setNome(rs.getString("nome"));
                matricula.setAnosCompletos(rs.getInt("anosCompletos"));
                matricula.setEmail(rs.getString("email"));
                matricula.setEndereco(rs.getString("endereco"));
                matricula.setCep(rs.getString("cep"));
                matricula.setTelefone(rs.getString("telefone"));
                matricula.setUser(rs.getString("usuario"));
                matricula.setPassword(rs.getString("senha"));
                matricula.setCurso(rs.getString("curso"));
                matricula.setObservacao(rs.getString("observacao"));
                matricula.setAtivo(rs.getBoolean("ativo"));
                matriculas.add(matricula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matriculas;
    }
    
}
