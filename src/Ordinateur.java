import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Ordinateur extends Utilisateur implements ActionListener{
	int cpt = 0 ;
	int x , y;
	int indice_bateau_liste;

	
	public Ordinateur(int id) {
		super(id);
		this.nom="Ordinateur";
		joueur_actif=false;
		desactiver_List();
		g.desactiver_grille();
		for(Case c : g.grille){
			c.addActionListener(this);
		}
	}
	
	void construire(){
		if(joueur_actif){
			while(cpt < nbr_bateaux){
				indice_bateau_liste= (int) (Math.random() * Navire.length);
				bateau=bateau(Navire[indice_bateau_liste]);
				x= (int) (Math.random() *  (10 - 0 ) )   ;
				y= (int) (Math.random() *  (10 - 0 ) )   ;
					if(cases_vides(bateau,x,y)){
						creer_bateau(bateau,x,y);
						System.out.println(bateau.id);
						cpt++;
						x=0;y=0;

												}	
									}
		if(cpt == nbr_bateaux){
			g.hide_grille();
								}
			
			}
		
						}
			
	public void detruire(Utilisateur u){
		int x = (int) (Math.random() *  (10 - 0 )  )  ;
		int y = (int) (Math.random() *  (10 - 0 )  )  ;
		
		Case c = chercher_case(x,y,u);	
		//tester si la case est deja touchée !!
		
		/*if(c.isE_case_touchee() ){
			JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);
								}*/
			Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
			u.touchee = detruire_bateau(u,n,c);			
										}								
	
	public Case chercher_case(int x , int y , Utilisateur u){
		for(Case c : u.g.grille){
			if(x == c.getI() && y==c.getJ()){
				return c;
											}
		}
		return null;
			
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(joueur_actif){
			Case c = (Case) e.getSource();
			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);		
									}
				else {
				Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
				touchee = detruire_bateau(this,n,c);
					
					}
									
									}				
					}	
	}
	
	


