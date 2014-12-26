import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mode_jeu {
	
	void joueur_joueur(JFrame f ){
		boolean construction = true ;
		boolean joueur = true ;
		
		Joueur user1 = new Joueur(1);
		Joueur user2 = new Joueur(2);
		
		JPanel panel_grille = new JPanel(new BorderLayout());

		panel_grille.add(user1,BorderLayout.NORTH);
		panel_grille.add(user2,BorderLayout.CENTER);
		
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    f.pack();
	    f.setSize(new Dimension(800, 400));
	    
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
 	    		//user2.construire();
 	    		if(user2.cpt == user2.nbr_bateaux){
 	    			construction = false;
 	    			user1.setjoueur_actif(true);
 	    			user2.setjoueur_actif(true);
 	    			user2.g.activer_grille();
 	    											}
 	    							}    	
 	    }

	    while(!construction ){
	    	// si user2 touche une case vide de user :
	    	if(user1.touchee == 0 ){
 				user1.g.desactiver_grille();
 				user2.g.activer_grille();
 				user1.touchee = -1;
 								}
	    	
	    	// si user touche une case vide de user2 :
 	    	if(user2.touchee == 0){
 	    			user2.g.desactiver_grille();
	    			user1.g.activer_grille();
 	    			//user2.detruire(user);
	    			user2.touchee = -1;				
 	    			}
	    					}
	    
	}

}
