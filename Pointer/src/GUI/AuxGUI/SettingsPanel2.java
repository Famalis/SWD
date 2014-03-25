/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.AuxGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class SettingsPanel2 extends JPanel{
	
	private JButton startButton, drawPeceptron;
	
	public SettingsPanel2() {
		super();
	}
	
	public void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		startButton = new JButton("Start");
		add(startButton);
		
		drawPeceptron = new JButton("Narsyuj perceptron");
		add(drawPeceptron);
		
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getDrawPeceptron() {
		return drawPeceptron;
	}
	
}
