/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AuxGUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class SettingsPanel extends JPanel {

	private JButton drawVectorButton;

	public SettingsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		drawVectorButton = new JButton("Rysuj perceptron");
		add(drawVectorButton);
	}

	public JButton getDrawVectorButton() {
		return drawVectorButton;
	}

}
