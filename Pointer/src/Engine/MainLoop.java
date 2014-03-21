/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import GUI.Easel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergio
 */
public class MainLoop {

	public MainLoop() {
		super();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				Easel frame = new Easel();
				frame.initialize();
			}
		});

	}

	public static void main(String[] args) {
		new MainLoop();
	}
}
