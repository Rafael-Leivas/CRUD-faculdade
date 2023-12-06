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
        PreparedStatement  prepStmt = null;
        ResultSet rs = null;

        try{
            conn = ConexaoBanco.getConexao();

            prepStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            prepStmt.setString(1, matricula.getNome());
            prepStmt.setInt(2, matricula.getAnosCompletos());
            prepStmt.setString(3, matricula.getEmail());
            prepStmt.setString(4, matricula.getEndereco());
            prepStmt.setString(5, matricula.getCep());
            prepStmt.setString(6, matricula.getTelefone());
            prepStmt.setString(7, matricula.getUsuario());
            prepStmt.setString(8, matricula.getSenha());
            prepStmt.setString(9, matricula.getCurso());
            prepStmt.setString(10, matricula.getObservacao());
            prepStmt.setBoolean(11, matricula.getAtivo());
            prepStmt.execute();

            rs = prepStmt.getGeneratedKeys();
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
        PreparedStatement  prepStmt = null;

        try{
            conn = ConexaoBanco.getConexao();

            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, matricula.getNome());
            prepStmt.setInt(2, matricula.getAnosCompletos());
            prepStmt.setString(3, matricula.getEmail());
            prepStmt.setString(4, matricula.getEndereco());
            prepStmt.setString(5, matricula.getCep());
            prepStmt.setString(6, matricula.getTelefone());
            prepStmt.setString(7, matricula.getUsuario());
            prepStmt.setString(8, matricula.getSenha());
            prepStmt.setString(9, matricula.getCurso());
            prepStmt.setString(10, matricula.getObservacao());
            prepStmt.setBoolean(11, matricula.getAtivo());
            prepStmt.setInt(12, matricula.getId());
            prepStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

    public static void remover(Matricula matricula) {
        String query = "DELETE FROM matricula WHERE id = ?";

        Connection conn = null;
        PreparedStatement  prepStmt = null;

        try{
            conn = ConexaoBanco.getConexao();

            prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, matricula.getId());
            prepStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Matricula> listar() {
        ArrayList<Matricula> matriculas = new ArrayList<>();

        String query = "SELECT id, nome, anosCompletos, email, endereco, cep, telefone, usuario, senha,curso,observacao,ativo FROM matricula";

        Connection conn = null;
        Statement prepStmt = null;
        ResultSet rs = null;

        try{
            //TODO: Conectar

            conn = ConexaoBanco.getConexao();
            prepStmt = conn.createStatement();
            rs = prepStmt.executeQuery(query);

            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setId(rs.getInt("id"));
                matricula.setNome(rs.getString("nome"));
                matricula.setAnosCompletos(rs.getInt("anosCompletos"));
                matricula.setEmail(rs.getString("email"));
                matricula.setEndereco(rs.getString("endereco"));
                matricula.setCep(rs.getString("cep"));
                matricula.setTelefone(rs.getString("telefone"));
                matricula.setUsuario(rs.getString("usuario"));
                matricula.setSenha(rs.getString("senha"));
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
