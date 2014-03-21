/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.AuxGUI;

import Engine.Point;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sergio
 */
public class SettingsPanel extends JPanel{
	
	private JTextField poleWariancji;
	private JButton button;
	private JLabel etykietaSrodek, etykietaPromien, maxx, maxy;
	public SettingsPanel() {
		super();
	}
	
	public void initalize() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		maxx = new JLabel("X: "+(-1*Point.screenWidth/2)+" : "+(Point.screenWidth/2));
		add(maxx);
		
		maxy = new JLabel("Y: "+(-1*Point.screenWidth/2)+" : "+(Point.screenWidth/2));
		add(maxy);
		
		poleWariancji = new JTextField();
		poleWariancji.setColumns(4);
		add(new JLabel("Wariancja:"));
		add(poleWariancji);
		
		add(new JLabel("Środek:"));
		etykietaSrodek = new JLabel("0.0, 0.0");
		add(etykietaSrodek);
		
		add(new JLabel("Promień:"));
		etykietaPromien = new JLabel("0.0");
		add(etykietaPromien);
		
		button = new JButton("Ustaw");
		add(button);
		
	}

	public JTextField getPoleWariancji() {
		return poleWariancji;
	}

	public JButton getButton() {
		return button;
	}

	public JLabel getEtykietaSrodek() {
		return etykietaSrodek;
	}

	public JLabel getEtykietaPromien() {
		return etykietaPromien;
	}

	public JLabel getMaxx() {
		return maxx;
	}

	public JLabel getMaxy() {
		return maxy;
	}
	
}
