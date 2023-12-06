import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InicialPanel extends JPanel {
	private AppFrame frame;
	private JButton tarefasBtn;

	public InicialPanel(AppFrame appFrame) {
		frame = appFrame;

		tarefasBtn = new JButton("Matriculas");
		tarefasBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaMatriculas();
			}
		});
		add(tarefasBtn);
	}

} // fim da class InicialPanel
