	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.ListSelectionModel;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;

	public class PainelMatriculas extends JPanel {
		private AppFrame frame;
		private JButton novaMatriculaBtn;
		private JButton editarMatriculaBtn;
		private JButton removerMatriculaBtn;
		private JTable tabela;
		private TelaMatriculasModelo tableModel;

		public PainelMatriculas(AppFrame appFrame) {
			frame = appFrame;

			setLayout(new BorderLayout(10, 10));

			criarComandosPanel();
			criarTabelaPanel();
		}

		public void recarregar() {
			tableModel.carregar(BancoMatricula.listar());
		}

		private void criarComandosPanel() {
			JPanel panel = new JPanel();
			FlowLayout layout = (FlowLayout) panel.getLayout();
			layout.setAlignment(FlowLayout.RIGHT);

			novaMatriculaBtn = new JButton("Criar Nova Matricula");
			novaMatriculaBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.mostrarFormMatriculas(null);
				}
			});
			panel.add(novaMatriculaBtn);

			editarMatriculaBtn = new JButton("Alterar Matricula");
			editarMatriculaBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.mostrarFormMatriculas(tableModel.getMatricula(tabela.getSelectedRow()));
				}
			});
			panel.add(editarMatriculaBtn);

			removerMatriculaBtn = new JButton("Remover Matricula");
			removerMatriculaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Matricula matricula = tableModel.getMatricula(tabela.getSelectedRow());
					int resposta = JOptionPane.showConfirmDialog(PainelMatriculas.this, "Deseja realmente remover?",
							AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						BancoMatricula.remover(matricula);
						tableModel.remover(matricula);
					}
				}
			});
			panel.add(removerMatriculaBtn);

			add(panel, BorderLayout.NORTH);

			desabilitarBtns();
		}

		private void criarTabelaPanel() {
			JPanel panel = new JPanel();

			tableModel = new TelaMatriculasModelo(BancoMatricula.listar());
			tabela = new JTable(tableModel);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						if (tabela.getSelectedRow() >= 0) {
							habilitarBtns();
						} else {
							desabilitarBtns();
						}
					}
				}
			});

			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setPreferredSize(new Dimension(1500, 600));
			panel.add(scrollPane);

			add(panel, BorderLayout.CENTER);
		}

		private void habilitarBtns() {
			editarMatriculaBtn.setEnabled(true);
			removerMatriculaBtn.setEnabled(true);
		}

		private void desabilitarBtns() {
			editarMatriculaBtn.setEnabled(false);
			removerMatriculaBtn.setEnabled(false);
		}
	}