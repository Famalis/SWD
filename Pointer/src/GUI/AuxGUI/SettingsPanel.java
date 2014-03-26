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

	private JButton drawVectorButton, startButton, select0Cluster, select1Cluster;

	public SettingsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		drawVectorButton = new JButton("Rysuj perceptron");
		add(drawVectorButton);
		startButton = new JButton("Uruchom");
		add(startButton);
		select0Cluster = new JButton("Wybierz 0 punkty");
		add(select0Cluster);
		select1Cluster = new JButton("Wybierz 1 punkty");
		add(select1Cluster);
	}

	public JButton getDrawVectorButton() {
		return drawVectorButton;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JButton getSelect0Cluster() {
		return select0Cluster;
	}

	public JButton getSelect1Cluster() {
		return select1Cluster;
	}
	
}
