import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean construction = true ;
		int compteur = 0;
		JFrame f = new JFrame("Bataille_Navale");
		Joueur user = new Joueur(1);
		Joueur user2 = new Joueur(2);
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
	    
	    	while(user.isjoueur_actif()){
	    		user2.setjoueur_actif(false);	
	    							}
	    
	    	while(!user.isjoueur_actif()){
	    		user2.setjoueur_actif(true);
	    		if(user2.cpt == user2.nbr_bateaux){
	    			construction = false;
	    			user.setjoueur_actif(true);
	    			user.g.activer_grille();
	    											}
	    							}
	    
	    
	    while(true){
	    	if(user.touche == 0){
	    			user2.setjoueur_actif(true);
	    			user.setjoueur_actif(false);
	    			user.g.desactiver_grille();
	    			user2.g.activer_grille();
	    			}
	    	if(user2.touche == 0 ){
    				user.setjoueur_actif(true);
    				user2.setjoueur_actif(false);
    				user2.g.desactiver_grille();
    				user.g.activer_grille();
    							}
	    	
	    					}
	    
	    					}
	    
	    
	   
		
	}

}