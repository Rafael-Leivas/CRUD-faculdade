import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MatriculaTableModel extends AbstractTableModel {
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	private String[] colunas = new String[] { "Id", "Nome", "AnosCompletos", "Email", "Endereco", "Cep", "Telefone", "Usuario", "Senha", "Curso", "Observacao", "Ativo" };

	public MatriculaTableModel(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public int getRowCount() {
		return matriculas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String columnName = null;

		if (columnIndex >= 0 && columnIndex < colunas.length) {
			columnName = colunas[columnIndex];
		}
		return columnName;
	}	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;

		if (rowIndex >= 0 && rowIndex < matriculas.size()) {
			Matricula matricula = matriculas.get(rowIndex);

			switch (columnIndex) {
			case 0:
				value = Integer.toString(matricula.getId());
				break;
			case 1:
				value = matricula.getNome();
				break;
			case 2:
				value = String.valueOf(matricula.getAnosCompletos());
				break;
			case 3:
				value = matricula.getEmail();
				break;
			case 4:
				value = matricula.getEndereco();
				break;
			case 5:
				value = matricula.getCep();
				break;
			case 6:
				value = matricula.getTelefone();
				break;
			case 7:
				value = matricula.getUsuario();
				break;
			case 8:
				value = matricula.getSenha();
				break;
			case 9:
				value = matricula.getCurso();
				break;
			case 10:
				value = matricula.getObservacao();
				break;
			case 11:
				value = String.valueOf(matricula.getAtivo());
				break;
			default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
			}
		}

		return value;
	}

	public Matricula getMatricula(int rowIndex) {
		Matricula matricula = null;

		if (rowIndex >= 0 && rowIndex < matriculas.size()) {
			matricula = matriculas.get(rowIndex);
		}

		return matricula;
	}

	public void carregar(List<Matricula> matriculas) {
		this.matriculas = matriculas;
		fireTableDataChanged();
	}

	public void remover(Matricula matricula) {
		matriculas.remove(matricula);
		fireTableDataChanged();
	}

} // fim da classe TarefaTabelaModel
