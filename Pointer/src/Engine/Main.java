/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.Models.Perceptron;
import Engine.Models.Point;
import GUI.AuxGUI.SettingsFrame;
import GUI.Easel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author sergio
 */
public class Main {
	
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
						es.setSelect0(false);
						es.setSelect1(false);
						s.getPanel().getDrawVectorButton().setEnabled(false);
						System.out.println("Draw perceptron");
					}
					
				});
				s.getPanel().getStartButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<Point> trainingSet = new ArrayList<>();
						for (int i = 0; i<10000; i++) {
							double x = Math.random()*(Point.getScreenWidth()/2);
							double y = Math.random()*(Point.getScreenWidth()/2);
							Point p = new Point();
							p.setXThroughAxisValue(x);
							p.setYThroughAxisValue(y);
							if(p.getAxisY()>=20) {
								p.setStatus(1);
							} else {
								p.setStatus(0);
							}
						}
						es.getBoard().getPerceptron().learn(trainingSet, es);
					}
					
				});
				
				s.getPanel().getSelect0Cluster().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						es.setSelect0(true);
						es.setSelect1(false);
					}
					
				});
				s.getPanel().getSelect1Cluster().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						es.setSelect1(true);
						es.setSelect0(false);
					}
					
				});
				es.addMouseListener(new EaselMouseListener(es, s));
			}
		});
	}

}
