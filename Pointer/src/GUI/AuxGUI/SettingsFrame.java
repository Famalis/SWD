/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.AuxGUI;

import Engine.Models.Point;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author sergio
 */
public class SettingsFrame extends JFrame{
	
	private SettingsPanel panel;
	
	public SettingsFrame() {
		setLayout(new FlowLayout());
		panel = new SettingsPanel();
		add(panel);
		setTitle("Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Point.getScreenWidth(), Point.getScreenHeight());		
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);	
		pack();
	}
	
	public SettingsPanel getPanel() {
		return panel;
	}
}
