package Controleur;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Joueur_Joueur extends JFrame{

	JPanel panel_joueur;
	boolean construction = true ;
	boolean joueur = true ;
	Joueur user1;
	Joueur user2;

	public Joueur_Joueur(){

		user1 = new Joueur(1);
		user2 = new Joueur(2);
		panel_joueur = new JPanel(new BorderLayout());

		panel_joueur.add(user1,BorderLayout.NORTH);
		panel_joueur.add(user2,BorderLayout.SOUTH);
		this.add(panel_joueur);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		this.pack();
		this.setSize(new Dimension(800, 400));

		while(construction){
			if(joueur){
				user1.setjoueur_actif(true);
				if(user1.cpt==user1.nbr_bateaux){
					user1.setjoueur_actif(false);
					joueur=false;
				} 			
			}	    
			if(!joueur){
				user2.setjoueur_actif(true);

				if(user2.cpt == user2.nbr_bateaux){
					construction = false;
					user1.setjoueur_actif(true);
					user2.setjoueur_actif(true);
					user2.g.activer_grille();
				}
			}    	
		}

		while(!construction && !user1.liste_navire.isEmpty() && !user2.liste_navire.isEmpty()){
			// si user2 touche une case vide de user :
			if(user1.touchee == 0 ){
				user1.g.desactiver_grille();
				user2.g.activer_grille();
				user1.touchee = -1;
			}

			// si user1 touche une case vide de user2 :
			if(user2.touchee == 0){
				user2.g.desactiver_grille();
				user1.g.activer_grille();
				//user2.detruire(user);
				user2.touchee = -1;				
			}
		}

	}

}
