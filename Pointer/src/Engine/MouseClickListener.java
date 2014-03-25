/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import GUI.Easel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Sergio
 */
public class MouseClickListener implements MouseListener {

	private static final Logger LOGGER = Logger.getLogger(MouseClickListener.class.getCanonicalName());
	private Easel easel;
	private boolean block = false;

	public MouseClickListener(Easel easel) {
		super();
		this.easel = easel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!block) {
			block = true;
			//easel.setVisible(false);
			//LOGGER.info("Board clicked at " + e.getX() + " " + e.getY());
			if (easel.drawingVector()) {
				System.out.println("Vector Point selected: "+e.getX()+" "+e.getY());
				easel.drawVectorPoint(e.getX(), e.getY());
			} else {
				System.out.println("Point selected: "+e.getX()+" "+e.getY());
				easel.drawPoint(e.getX(), e.getY());
			}
			block = false;
		}
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
