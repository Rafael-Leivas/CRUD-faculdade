import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MatriculaFormPanel extends JPanel{
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private AppFrame frame;
    private JPanel matriculaFormPanel;
    private Matricula matricula;

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextArea observacaoTxt;
    private JCheckBox ativoCheckBox;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public MatriculaFormPanel(AppFrame appFrame){
        frame = appFrame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (matricula == null) {
                    idTxt.setText("");
                    nomeTxt.setText("");
                    observacaoTxt.setText("");
                } else {
                    idTxt.setText(Integer.toString(matricula.getId()));
                    nomeTxt.setText(matricula.getNome());
                }
            }

        });

        criarMatricula();
    }

    public void setMatricula(Matricula matricula){
        this.matricula = matricula;
    }

    private void criarMatricula(){
        JLabel rotulo;

        rotulo = new JLabel("Id");
        adicionarComponente(rotulo, 0, 0);
        idTxt = new JTextField(5);
        idTxt.setEditable(false);
        adicionarComponente(idTxt, 0, 1);

        rotulo = new JLabel("Nome Completo");
        adicionarComponente(rotulo, 1, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 1, 1);

        rotulo = new JLabel("Anos Completo");
        adicionarComponente(rotulo, 2, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 2, 1);

        rotulo = new JLabel("E-mail");
        adicionarComponente(rotulo, 3, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 3, 1);

        rotulo = new JLabel("Endereço");
        adicionarComponente(rotulo, 4, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 4, 1);

        rotulo = new JLabel("CEP");
        adicionarComponente(rotulo, 5, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 5, 1);

        rotulo = new JLabel("Telefone");
        adicionarComponente(rotulo, 6, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 6, 1);

        rotulo = new JLabel("Usuário");
        adicionarComponente(rotulo, 7, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 7, 1);

        rotulo = new JLabel("Senha");
        adicionarComponente(rotulo, 8, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 8, 1);

        rotulo = new JLabel("Curso");
        adicionarComponente(rotulo, 9, 0);

        String[] opcoesCursos = {"Curso 1", "Curso 2", "Curso 3"};
        cursoComboBox = new JComboBox<>(opcoesCursos);
        adicionarComponente(cursoComboBox, 9, 1);

        rotulo = new JLabel("Observação");
        adicionarComponente(rotulo, 10, 0);
        observacaoTxt = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(observacaoTxt);
        adicionarComponente(scrollPane, 10, 1, 1, 5);

        rotulo = new JLabel("Ativo");
        adicionarComponente(rotulo, 16, 0);
        ativoCheckBox = new JCheckBox();
        adicionarComponente(ativoCheckBox, 16, 1);

		adicionarBotoes();
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(componente, constraints);
        add(componente);
    }

	private void adicionarBotoes() {
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Dados salvos com sucesso!");
            }
        });
        adicionarComponente(salvarButton, 17, 0);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Edição cancelada.");
            }
        });
        adicionarComponente(cancelarButton, 17, 1);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }

    public boolean isAtivo() {
    return ativoCheckBox.isSelected();
    }

    private JComboBox<String> cursoComboBox;

    public String getCursoSelecionado() {
    return (String) cursoComboBox.getSelectedItem();
}



}