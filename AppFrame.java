import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
	public static final String titulo = "Sistema de Matricula";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private PainelInicial painelInicial;
	private PainelMatriculas painelMatriculas;
	private TelaCadastroMatricula telaCadastroMatricula;

	public AppFrame() {
		super(titulo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
		add(cardsPane);

		criarCards();
	}

	public void mostrar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void mostrarListaMatriculas() {
		painelMatriculas.recarregar();
		layout.show(cardsPane, PainelMatriculas.class.getName());
	}
	
	public void mostrarFormMatriculas(Matricula matricula) {
		telaCadastroMatricula.setMatricula(matricula);
		layout.show(cardsPane, TelaCadastroMatricula.class.getName());
	}

	private void criarCards() {
		painelInicial = new PainelInicial(this);
		cardsPane.add(painelInicial, PainelInicial.class.getName());

		painelMatriculas = new PainelMatriculas(this);
		cardsPane.add(painelMatriculas, PainelMatriculas.class.getName());

		telaCadastroMatricula = new TelaCadastroMatricula(this);
		cardsPane.add(telaCadastroMatricula, TelaCadastroMatricula.class.getName());
	}
} // fim da classe AppFrame
