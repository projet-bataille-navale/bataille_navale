import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Ordinateur extends Utilisateur implements ActionListener{
	int cpt = 0 ;
	int x , y;
	int indice_bateau_liste;
	Case c;
	public Ordinateur(int id) {
		super(id);
		this.nom="Ordinateur";
		joueur_actif=true;
		desactiver_List();
		for(Case c : g.grille){
			c.addActionListener(this);
		}
	}
	
	void construire(){
		if(joueur_actif){
			while(cpt < nbr_bateaux){
				indice_bateau_liste=(int) (Math.random() * Navire.length);
				bateau=bateau(Navire[indice_bateau_liste]);
				x= (int) (Math.random() *  (9 - 0 + 1 ) ) + 0  ;
				y= (int) (Math.random() *  (9 - 0 + 1 ) ) + 0  ;
					if(cases_vides(bateau,x,y)){
						creer_bateau(bateau,x,y);
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
		int x = (int) (Math.random() *  (9 - 1 ) )  ;
		int y = (int) (Math.random() *  (9 - 1 ) )  ;
		System.out.println(x +" " + y +" " + u.nom);
		c = chercher_case(x,y,u.g);			
		//tester si la case est deja touchée !!
		if(c.isE_case_touchee() ){
			JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);
								}
			else{
			Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
			touchee = detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
			System.out.println(touchee);
				}				
										}								
	
	public Case chercher_case(int x , int y , Grille gr){
		for(Case c : gr.grille){
			if(x == c.getI() && y==c.getJ()){
				return c;
											}
		}
		return null;
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!joueur_actif){
			c = (Case) e.getSource();
			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);		
									}
				else{
				Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
				touchee = detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
					}
									
				}				
		if(liste_navire.isEmpty()){
			JOptionPane.showMessageDialog(this,  "Félicitation !! vous avez gagné !!"," Attention ",JOptionPane.WARNING_MESSAGE);	
									}
					}	
	}
	
	


