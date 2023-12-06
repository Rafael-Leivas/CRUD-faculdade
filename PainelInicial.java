import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelInicial extends JPanel {
	private AppFrame frame;
	private JButton tarefasBtn;

	public PainelInicial(AppFrame appFrame) {
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

}
