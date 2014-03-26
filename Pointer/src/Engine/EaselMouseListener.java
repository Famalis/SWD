/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import Engine.Models.Point;
import GUI.AuxGUI.SettingsFrame;
import GUI.Easel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author sergio
 */
public class EaselMouseListener implements MouseListener{

	private Easel easel;
	private SettingsFrame settingsFrame;
	
	public EaselMouseListener(Easel ea, SettingsFrame sf) {
		super();
		easel = ea;
		settingsFrame = sf;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(easel.isDrawingVector()) {
			if(easel.getBoard().getPerceptron().getStartPoint()==null) {
				easel.getBoard().getPerceptron().setStartPoint(
					new Point(e.getX(), e.getY()));
				System.out.println("Perceptron start set");
			} else if (easel.getBoard().getPerceptron().getEndPoint()==null){
				easel.getBoard().getPerceptron().setEndPoint(
					new Point(e.getX(), e.getY()));
				System.out.println("Perceptron end set");
				easel.setDrawingVector(false);
				settingsFrame.getPanel().getDrawVectorButton().setEnabled(true);
			}
			
		} else if (easel.isSelect0()){
			easel.getBoard().getGroup0().add(new Point(e.getX(), e.getY(), 0));
			System.out.println("Select point for cluster 0");
		} else if (easel.isSelect1()){
			easel.getBoard().getGroup1().add(new Point(e.getX(), e.getY(), 1));
			System.out.println("Select point for cluster 1");
		}
		easel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
