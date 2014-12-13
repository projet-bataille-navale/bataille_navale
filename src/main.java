import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Bataille_Navale");
		//Bateaux b = new Bateaux();
		Utilisateur user = new Joueur(1);
		Utilisateur user2 = new Joueur(2);
		JPanel panel_grille = new JPanel(new BorderLayout());

		//panel_grille.add(b,BorderLayout.NORTH);
		panel_grille.add(user.g,BorderLayout.NORTH);
		panel_grille.add(user2.g,BorderLayout.CENTER);
		f.add(panel_grille);
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    f.pack();
	    f.setSize(new Dimension(800, 400));
	    
		
	}

}
