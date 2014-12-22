import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class Ordinateur extends Utilisateur implements ActionListener{
	int cpt = 0 ;
	int x , y;
	int indice_bateau_liste;
	Case c;
	boolean detruire = false;
	public Ordinateur(int id) {
		super(id);
		this.nom="Ordinateur";
		//joueur_actif=true;
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
				x=(int) (Math.random() * 9) ;
				y=(int) (Math.random() * 9) ;
					if(cases_vides(bateau,x,y)){
						creer_bateau(bateau,x,y);
						cpt++;
						x=0;y=0;

												}	
									}
		if(cpt == nbr_bateaux){
			detruire = true;
			
								}
			
			}
		
						}
			

								


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		desactiver_List();
	}
	
	public Case chercher_case(int x , int y , Grille gr){
		for(Case c : gr.grille){
			if(x == c.getI() && y==c.getJ()){
				return c;
											}
		}
		return null;
			
	}

	public void detruire(Utilisateur u){
			int x = (int) (Math.random() * 9) ;
			int y =(int) (Math.random() * 9) ;
			c = chercher_case(x,y,u.g);			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);
									}
			else if(c.getId_case()==-1){ // si l'id de la case -1 ça veut dire que la case est vide ne contient aucun bateau
					c.setBackground(Color.green);
					c.setE_case_touchee(true);
					u.touchee=0;
										}
				else{
				Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
				detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
					}				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!joueur_actif && detruire==true){
			c = (Case) e.getSource();
			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);		
									}
			else{
			Navire n=chercher_bateau(c.getId_case());// chercher le bateau dans la memoire !!
				if(c.getId_case()==-1){ // si l'id de la case -1 ça veut dire que la case est vide ne contient aucun bateau
					c.setBackground(Color.green);
					c.setE_case_touchee(true);
					touchee=0;
										}
				else{
				detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
					}
									}
				}
		
							
		if(liste_navire.isEmpty()){
			JOptionPane.showMessageDialog(this,  "Félicitation !! vous avez gagné !!"," Attention ",JOptionPane.WARNING_MESSAGE);	
									}
					}
		
	}
	
	


