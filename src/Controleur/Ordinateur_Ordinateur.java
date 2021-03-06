package Controleur;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ordinateur_Ordinateur extends JFrame{
	JPanel panel_joueur;
	boolean construction = true ;
	boolean joueur = true ;
	Ordinateur user1 ;
	Ordinateur user2 ;

	public Ordinateur_Ordinateur(){
		user1 = new Ordinateur(1);
		user2 = new Ordinateur(2);
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
				user1.construire();
				if(user1.cpt==user1.nbr_bateaux){
					user1.setjoueur_actif(false);
					joueur=false;
				} 			
			}	    
			if(!joueur){
				user2.setjoueur_actif(true);
				user2.construire();
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(user2.cpt == user2.nbr_bateaux){
					construction = false;
					user1.setjoueur_actif(true);
					user2.setjoueur_actif(true);
					user1.detruire(user2);
				}
			}    	
		}

		while(!construction && !user1.liste_navire.isEmpty() && !user2.liste_navire.isEmpty() ){
			// si user1 touche une case qui contient un bateau il va rejoueur !!
			if(user1.touchee == 1)
				user2.detruire(user1);
			
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// si user2 touche une case qui contient un bateau il va rejoueur !!							
			if(user2.touchee == 1)
				user1.detruire(user2);
			
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// si user2 touche une case vide de user1 / user1 c'est a son role de joueur:
			if(user1.touchee == 0 ){
				user1.detruire(user2);
				user1.touchee = -1;
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			// si user1 touche une case vide de user2 / user2 c'est a son role de joueur :
			if(user2.touchee == 0){
				user2.detruire(user1);
				user2.touchee = -1;
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

}

