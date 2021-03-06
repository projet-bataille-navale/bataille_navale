package Vue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modele.Case;


public class Grille extends JPanel {

	public ArrayList<Case> grille;
	int i,j;// les i "x" et les j "y" pour la contruction de la grille (parcourir)

	JPanel panel_grille;

	public Grille() {
		panel_grille = new JPanel( new GridLayout(10, 10) );

		grille = new ArrayList<Case>();

		// creation de la grille a la memoire ! 
		for(i=0; i<10; i++){
			for(j=0; j<10; j++){
				grille.add(new Case(-1,i,j,false,true,false));			  
			}
		}
		// creation de la grille sur la vue !
		for(Case y : grille){
			y.setBackground(Color.blue);
			y.setPreferredSize(new Dimension(30, 15));
			repaint();
			y.setEnabled(false);
			panel_grille.add(y);		
		}

		this.add(panel_grille);
	}

	//Activer la grille

	public void activer_grille(){
		for(Case y : grille){
			y.setEnabled(true);		
		}
	}

	//désactiver la grille

	public void desactiver_grille(){
		for(Case y : grille){
			y.setEnabled(false);		
		}
	}

	public void hide_grille(){
		for(Case y : grille){
			y.setBackground(Color.WHITE);		
		}
	}


}


