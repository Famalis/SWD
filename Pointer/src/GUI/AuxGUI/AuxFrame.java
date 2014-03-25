/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.AuxGUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author Sergio
 */
public class AuxFrame extends JFrame{
	
	public JList areaPointsList;
	public JTextArea field;
	private SettingsPanel2 settingsPanel;
	
	public AuxFrame() {
		super();
	}
	
	public void initialize() {
		setLayout(new FlowLayout());
		/*
		field = new JTextArea();
		field.setColumns(10);
		field.setRows(6);
		field.setLineWrap(true);
		add(field);
				*/
		settingsPanel = new SettingsPanel2();
		settingsPanel.initialize();
		add(settingsPanel);
		setTitle("Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 280);
		setVisible(true);
		
		pack();
	}

	public SettingsPanel2 getSettingsPanel() {
		return settingsPanel;
	}
	
	public JButton getDrawPerceptronButton() {
		return settingsPanel.getDrawPeceptron();
	}
	
	public JButton getStartButton() {
		return settingsPanel.getStartButton();
	}
}
