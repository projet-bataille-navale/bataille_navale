import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class Ordinateur extends Utilisateur{
	int cpt = 0;
	int x , y;
	int indice_bateau_liste , touche = -1;
	boolean detruire;
	
	public Ordinateur(int id) {
		super(id);
		this.nom="Ordinateur";
		desactiver_List();
		if(joueur_actif){
		while(cpt < nbr_bateaux){
			indice_bateau_liste=(int) (Math.random() * Navire.length);
			bateau=bateau(Navire[indice_bateau_liste]);
			x=(int) (Math.random() * 9) ;
			y=(int) (Math.random() * 9) ;
				if(cases_vides(bateau,x,y)){
					creer_bateau(bateau,x,y);
					cpt++;
					x=0;y=0;
											}	
								}
		
		if(cpt == nbr_bateaux){
			g.hide_grille();
			joueur_actif=false;
			detruire = true;
			JOptionPane.showMessageDialog(this,  "le nombre de bateaux est atteint "," Attention ",JOptionPane.WARNING_MESSAGE);
							}
		while(joueur_actif){
		if(detruire){
			x=(int) (Math.random() * 9) ;
			y=(int) (Math.random() * 9) ;
			Case c = chercher_case(x,y);
			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);		
									}
			else{
			Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
				if(c.getId_case()==-1){ // si l'id de la case -1 ça veut dire que la case est vide ne contient aucun bateau
					c.setBackground(Color.green);
					c.setE_case_touchee(true);
					touche=0;
										}
				else{
				detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
					}
									}
				}
							}
		}
		if(liste_navire.isEmpty()){
			JOptionPane.showMessageDialog(this,  "Félicitation !! vous avez gagné !!"," Attention ",JOptionPane.WARNING_MESSAGE);	
									}
					}
									
									
				

								


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		desactiver_List();
	}
	
	public Case chercher_case(int x , int y){
		for(Case c : g.grille){
			if(x == c.getI() && y==c.getJ()){
				return c;
											}
		}
		return null;
			
	}
		
	
	

}
