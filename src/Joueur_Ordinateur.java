import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Joueur_Ordinateur extends JFrame {
	
JPanel panel_joueur;
	
	public Joueur_Ordinateur(){
		boolean construction = true ;
		boolean joueur = true ;
		Joueur user1 = new Joueur(1);
		Ordinateur user2 = new Ordinateur(2);
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
 	    		user2.construire();
 	    		if(user2.cpt == user2.nbr_bateaux){
 	    			construction = false;
 	    			user1.setjoueur_actif(true);
 	    			user2.setjoueur_actif(true);
 	    			user2.g.activer_grille();
 	    											}
 	    							}    	
 	    }
	    
	    for(Case c : user1.g.grille){
	    	System.out.println(c);
	    }
	    System.out.println();System.out.println();
	    for(Case c : user2.g.grille){
	    	System.out.println(c);
	    } 

	    while(!construction ){
	    	// si l'ordinateur touche une case qui contient un bateau il va rejoueur !!
	    	if(user1.touchee == 1){
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	    		user2.detruire(user1);
 	    							}
	    	// si user2 touche une case vide de user1 / user1 c'est a son role de joueur:
	    	if(user1.touchee == 0 ){
 				user2.g.activer_grille();
 				user1.touchee = -1;
 								}
	    	
	    	// si user1 touche une case vide de user2 / user2 c'est a son role de joueur :
 	    	if(user2.touchee == 0){
	    			user2.g.desactiver_grille();
	    			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 	    			user2.detruire(user1);
	    			user2.touchee = -1;	
 	    							}
	    					}
	    
	}

}
