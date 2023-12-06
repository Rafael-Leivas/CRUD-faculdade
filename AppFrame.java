import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
	public static final String titulo = "Sistema de Matriculas";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private InicialPanel inicialPanel;
	private MatriculaListPanel matriculaListPanel;
	private MatriculaFormPanel matriculaFormPanel;

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
		matriculaListPanel.recarregar();
		layout.show(cardsPane, MatriculaListPanel.class.getName());
	}
	
	public void mostrarFormMatriculas(Matricula matricula) {
		matriculaFormPanel.setMatricula(matricula);
		layout.show(cardsPane, MatriculaFormPanel.class.getName());
	}

	private void criarCards() {
		inicialPanel = new InicialPanel(this);
		cardsPane.add(inicialPanel, InicialPanel.class.getName());

		matriculaListPanel = new MatriculaListPanel(this);
		cardsPane.add(matriculaListPanel, MatriculaListPanel.class.getName());

		matriculaFormPanel = new MatriculaFormPanel(this);
		cardsPane.add(matriculaFormPanel, MatriculaFormPanel.class.getName());
	}
} // fim da classe AppFrame
