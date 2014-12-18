import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class Joueur extends Utilisateur implements ActionListener{
	int cpt , touche = -1 ;//cpt = compteur pour construire les bateaux
	Case c;
	boolean b=true , detruire=false ; // c pour differencier entre les bouton ou bien la liste des navires et les cases a la phase de la creation

	

	public Joueur(int id ) {
		super(id);
		this.nom="Joueur";
		//ajouter les listeners pour les cases de la grille
				for(Case c : g.grille){
					c.addActionListener(this);
				}
							}
	
		//creation du bateau sur la grille
		
		public void creer_bateau(Navire b,int x, int y){
			int tmp =0;			
			for(Case i : g.grille){
				// on test les x et les y et on test aussi si on a atteind le nombre de case du navire et on test si la case concerné pour la construction du bateau est vide
				if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case && i.isE_case_vide() ){
					i.setId_case(b.id);
					i.setE_case_vide(false);
					i.setBackground(Color.DARK_GRAY);			 
					y++;
					tmp++;
																					}
								
								}
	 												}
		
		//
		public void detruire_bateau(Navire b, int id,int x, int y){
			 for(Case i : g.grille){	
				 // on test si la case contient un bateau si oui donc la case contient l'id du bateau
					if(i.getI()==x && i.getJ()==y&& !i.isE_case_vide() && b.id==i.getId_case()){
						i.setE_bat(true);
						i.setE_case_touchee(true);
						i.setBackground(Color.red);
						b.nbr_case--;
						if(b.nbr_case == 0){
							JOptionPane.showMessageDialog(g,"Le "+  b.nom+" est coulé"," Attention ",JOptionPane.WARNING_MESSAGE);
							liste_navire.remove(b);
							b.nbr_case = -1;
											}
					
																	}
					
									
									}	 
		 															}
		
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if(joueur_actif){
				if(b && !detruire){
				activer_List();
				bateau=bateau(List.getSelectedValue());
				desactiver_List();
				g.activer_grille();
				b=false;
				}
			}
			
		}

		//
		public void actionPerformed(ActionEvent e) {
			if(joueur_actif){
			
				if(!b){
					c = (Case) e.getSource();
					//construction des bateaux
					if (cpt < nbr_bateaux ){
						if(!c.isE_case_vide()){
							JOptionPane.showMessageDialog(this,  "la case est deja remplie !"," Attention ",JOptionPane.WARNING_MESSAGE);
										}	
						else if(cases_vides(bateau,c.getI(),c.getJ())){
							creer_bateau(bateau,c.getI(),c.getJ());
							activer_List();
							g.desactiver_grille();
							cpt++;
							b=true;
																		}
				
			//si le nombre de bateaux est atteint le message se déclenche
				if(cpt == nbr_bateaux){
					desactiver_List();
					g.hide_grille();
					joueur_actif=false;
					detruire = true;
					JOptionPane.showMessageDialog(this,  "le nombre de bateaux est atteint "," Attention ",JOptionPane.WARNING_MESSAGE);
									}
											}
						}
			
			//la destruction des bateaux
			else if(detruire && b){
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
						touche=0;
											}
					else{
					detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
						}
										}
					}
								}
			if(liste_navire.isEmpty()){
				JOptionPane.showMessageDialog(this,  "Félicitation !! vous avez gagné !!"," Attention ",JOptionPane.WARNING_MESSAGE);	
										}
						}
													}

			


