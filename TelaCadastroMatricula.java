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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaCadastroMatricula extends JPanel{
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private AppFrame frame;
    private JPanel matriculaFormPanel;
    private Matricula matricula;

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextField anosCompletosTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField userTxt;
    private JTextField passwordTxt;
    private JComboBox<String> cursoComboBox;
    private JTextField cursoTxt;
    private JTextArea observacaoTxt;
    private JCheckBox ativoCheckBox;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public TelaCadastroMatricula(AppFrame appFrame){
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
                    anosCompletosTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    userTxt.setText("");
                    passwordTxt.setText("");
                    observacaoTxt.setText("");
                    ativoCheckBox.setSelected(false);
                } else {
                    idTxt.setText(Integer.toString(matricula.getId()));
                    nomeTxt.setText(matricula.getNome());
                    anosCompletosTxt.setText(Integer.toString(matricula.getAnosCompletos()));
                    emailTxt.setText(matricula.getEmail());
                    enderecoTxt.setText(matricula.getEndereco());
                    cepTxt.setText(matricula.getCep());
                    telefoneTxt.setText(matricula.getTelefone());
                    userTxt.setText(matricula.getUsuario());
                    passwordTxt.setText(matricula.getSenha());
                    observacaoTxt.setText(matricula.getObservacao());
                    ativoCheckBox.setSelected(matricula.getAtivo());
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

        rotulo = new JLabel("Nome Completo (Obrigatório)");
        adicionarComponente(rotulo, 1, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 1, 1);

        rotulo = new JLabel("Idade (Obrigatório)");
        adicionarComponente(rotulo, 2, 0);
        anosCompletosTxt = new JTextField(30);
        adicionarComponente(anosCompletosTxt, 2, 1);

        rotulo = new JLabel("E-mail (Obrigatório)");
        adicionarComponente(rotulo, 3, 0);
        emailTxt = new JTextField(30);
        adicionarComponente(emailTxt, 3, 1);

        rotulo = new JLabel("Endereço (Obrigatório)");
        adicionarComponente(rotulo, 4, 0);
        enderecoTxt = new JTextField(30);
        adicionarComponente(enderecoTxt, 4, 1);

        rotulo = new JLabel("CEP");
        adicionarComponente(rotulo, 5, 0);
        cepTxt = new JTextField(30);
        adicionarComponente(cepTxt, 5, 1);

        rotulo = new JLabel("Telefone");
        adicionarComponente(rotulo, 6, 0);
        telefoneTxt = new JTextField(30);
        adicionarComponente(telefoneTxt, 6, 1);

        rotulo = new JLabel("Usuário (Obrigatório)");
        adicionarComponente(rotulo, 7, 0);
        userTxt = new JTextField(30);
        adicionarComponente(userTxt, 7, 1);

        rotulo = new JLabel("Senha (Obrigatório)");
        adicionarComponente(rotulo, 8, 0);
        passwordTxt = new JPasswordField(30);
        adicionarComponente(passwordTxt, 8, 1);

        rotulo = new JLabel("Curso");
        adicionarComponente(rotulo, 9, 0);

        String[] opcoesCursos = {"Análise e Desenvolvimento de sistemas", "Desenvolvimento de Jogos", "Design Gráfico"};
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

		criarBotoes();
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

    private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 18, 1, 2, 3);
	}

    private void criarSalvarBtn(JPanel panel) {
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificarCamposObrigatorios()){
                    if (matricula == null) {
                        matricula = new Matricula();
                        matricula.setNome(nomeTxt.getText());
                        try{
                            matricula.setAnosCompletos(Integer.parseInt(anosCompletosTxt.getText()));
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(TelaCadastroMatricula.this, "Insira um valor inteiro válido para a idade!",
                            AppFrame.titulo, JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        matricula.setEmail(emailTxt.getText());
                        matricula.setEndereco(enderecoTxt.getText());
                        matricula.setCep(cepTxt.getText());
                        matricula.setTelefone(telefoneTxt.getText());
                        matricula.setUsuario(userTxt.getText());
                        matricula.setSenha(passwordTxt.getText());
                        matricula.setCurso(getCursoSelecionado());
                        matricula.setObservacao(observacaoTxt.getText());
                        matricula.setAtivo(isAtivo());
                        BancoMatricula.inserir(matricula);
                    } else {
                        matricula.setId(Integer.parseInt(idTxt.getText()));
                        matricula.setNome(nomeTxt.getText());
                        try{
                            matricula.setAnosCompletos(Integer.parseInt(anosCompletosTxt.getText()));
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(TelaCadastroMatricula.this, "Insira um valor inteiro válido para a idade!",
                            AppFrame.titulo, JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        matricula.setEmail(emailTxt.getText());
                        matricula.setEndereco(enderecoTxt.getText());
                        matricula.setCep(cepTxt.getText());
                        matricula.setTelefone(telefoneTxt.getText());
                        matricula.setUsuario(userTxt.getText());
                        matricula.setSenha(passwordTxt.getText());
                        matricula.setCurso(getCursoSelecionado());
                        matricula.setObservacao(observacaoTxt.getText());
                        matricula.setAtivo(isAtivo());
                        BancoMatricula.editar(matricula);
                    }

                    JOptionPane.showMessageDialog(TelaCadastroMatricula.this, "Tarefa salva com sucesso!", AppFrame.titulo,
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    frame.mostrarListaMatriculas(); 
                }else {
                    JOptionPane.showMessageDialog(TelaCadastroMatricula.this, "Preencha todos os campos obrigatórios!",
                            AppFrame.titulo, JOptionPane.ERROR_MESSAGE);
                }
            }   
        });
		panel.add(salvarButton);
    }

    public void criarCancelarBtn(JPanel panel){
        JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaMatriculas();
			}
		});
		panel.add(cancelarBtn);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }

    public boolean isAtivo() {
        return ativoCheckBox.isSelected();
    }

    public String getCursoSelecionado() {
        return (String) cursoComboBox.getSelectedItem();
    }
    
    private boolean verificarCamposObrigatorios() {
        // Verifica se os campos de texto obrigatórios têm pelo menos um caractere
        return !nomeTxt.getText().isEmpty() &&
                !anosCompletosTxt.getText().isEmpty() &&
                !emailTxt.getText().isEmpty() &&
                !enderecoTxt.getText().isEmpty() &&
                !userTxt.getText().isEmpty() &&
                !passwordTxt.getText().isEmpty();
    }

}