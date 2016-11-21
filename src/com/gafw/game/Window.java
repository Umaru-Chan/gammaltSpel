package com.gafw.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.gafw.game.Graphics.SimpleSpriteSheet;

public class Window {
	
	public static boolean resizable = false;
	public static JFrame f;
	public static BufferedImage window_icon = SimpleSpriteSheet.window_icon.getSheet();

	public Window(Dimension dim, String title, Game game) {
		
		f = new JFrame(title);
		
		f.setResizable(resizable);/*kommer alltid att vara false. nuff said. fuck java och resizable (f�r m�nga grafiska buggar...)*/
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - ((int)dim.getWidth() / 2)/* + 1920*/,
				    (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - ((int)dim.getHeight() / 2)); 
		/* look at that, efter fucking 15 minuter av googlande utan resultat
		 * och minst lika l�ng tid av att bara f�rs�ka sig fram, 
		 * s� lyckades jag komma p� att man m�ste skriva ".getDefaultToolkit()" efter Toolkit...
		 * (facePalm) 
		 */
		
		f.setPreferredSize(dim);
		f.setMinimumSize(dim);
		f.setMaximumSize(dim);
		
		f.setIconImage(window_icon);
		f.add(game);
		f.pack();
		f.setVisible(true);
		game.start();
	}
}
