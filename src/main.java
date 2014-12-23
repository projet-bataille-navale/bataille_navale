import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
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
	    
	    //user.setjoueur_actif(true);
 	    
 	    while(construction){
 	    
 	    	if(joueur){
 	    		user.setjoueur_actif(true);
 	    		if(user.cpt==user.nbr_bateaux){
 	    			joueur=false;
 	    						} 			
 	    					}
 	    
 	    	if(!joueur){
 	    		user2.setjoueur_actif(true);
 	    		user2.construire();
 	    		if(user2.cpt == user2.nbr_bateaux){
 	    			construction = false;
 	    			user2.g.activer_grille();
 	    			user.setjoueur_actif(false);
 	    			user2.setjoueur_actif(false);
 	    											}
 	    							}
 	    	
 	    }

	    while(!construction ){
	    	// si user2 touche une case vide de user :
	    	if(user.touchee == 0 ){
 				user.g.desactiver_grille();
 				user2.g.activer_grille();
 				user2.setjoueur_actif(false);
 				user.setjoueur_actif(true);
 				user.touchee = -1;
 								}
	    	
	    	// si user touche une case vide de user2 :
 	    	if(user2.touchee == 0){
 	    			user2.g.desactiver_grille();
	    			user.g.activer_grille();
 	    			user2.detruire(user);
 	    			user.setjoueur_actif(false);
 	    			user2.setjoueur_actif(true);
	    			user2.touchee = -1;				
 	    			}
 	    	
 	    					
	    					}
	    
	    					}
  
		
	}

