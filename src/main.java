import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean construction = true ;
		boolean joueur = true ;
		JFrame f = new JFrame("Bataille_Navale");
		
		Joueur user = new Joueur(1);
		Ordinateur user2 = new Ordinateur(2);
		JPanel panel_grille = new JPanel(new BorderLayout());

		panel_grille.add(user,BorderLayout.NORTH);
		panel_grille.add(user2,BorderLayout.CENTER);
		
		
		f.add(panel_grille);
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    f.pack();
	    f.setSize(new Dimension(800, 400));
	    
	    user.setjoueur_actif(true);
 	    
 	    while(construction){
 	    
 	    	if(joueur){
 	    		if(user.cpt==user2.nbr_bateaux){
 	    			joueur=false;
 	    						} 			
 	    					}
 	    
 	    	if(!joueur){
 	    		user2.setjoueur_actif(true);
 	    		user2.construire();
 	    		user2.g.hide_grille();
 	    							}
 	    	
 	    	if(user2.cpt == user2.nbr_bateaux){
    			construction = false;
    			user2.g.activer_grille();
    			user2.setjoueur_actif(false);
    			user.setjoueur_actif(false);
    		   		
    		 	   												
    											}
 	    	
 	    }

	    while(!construction ){
	    	if(user.touchee == 0 ){
 				user.g.desactiver_grille();
 				user2.g.activer_grille();
 				System.out.println(user2.touchee);
				user.touchee = -1;
 								}
	    	
 	    	if(user2.touchee == 0){
 	    			user2.g.desactiver_grille();
	    			user.g.activer_grille();
					user2.detruire(user);
					System.out.println(user.touchee);
					user2.touchee = -1;
 	    			}
 	    	
 	    					
	    }
	    
	    					}
  
		
	}

