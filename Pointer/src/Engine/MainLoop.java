/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.Models.Perceptron;
import GUI.AuxGUI.SettingsFrame;
import GUI.Easel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author sergio
 */
public class MainLoop {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Thread() {
			@Override
			public void run() {
				final Easel es = new Easel();
				es.initalization();
				
				final SettingsFrame s = new SettingsFrame();
				s.getPanel().getDrawVectorButton().addActionListener(new ActionListener() { 

					@Override
					public void actionPerformed(ActionEvent e) {
						es.getBoard().setPerceptron(new Perceptron());
						es.setDrawingVector(true);
						s.getPanel().getDrawVectorButton().setEnabled(false);
						System.out.println("Draw perceptron");
					}
					
				});
				es.addMouseListener(new EaselMouseListener(es, s));
			}
		});
	}

}
