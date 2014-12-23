import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Joueur extends Utilisateur implements ActionListener , ListSelectionListener{
	int cpt;//cpt = compteur pour construire les bateaux
	Case c ;
	boolean b=true ; // c pour differencier entre les bouton ou bien la liste des navires et les cases a la phase de la creation

	

	public Joueur(int id ) {
		super(id);
		this.nom="Joueur";
		//ajouter les listeners pour les cases de la grille
				for(Case c : g.grille){
					c.addActionListener(this);
				}		
		// listener pour la List graphique
		List.addListSelectionListener(this);
							}
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if(joueur_actif && b){
				activer_List();
				bateau=bateau(List.getSelectedValue());
				desactiver_List();
				g.activer_grille();
				b=false;
			}
			
		}

		//
		public void actionPerformed(ActionEvent e) {	
				if(!b && joueur_actif){
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
					c = null;
					JOptionPane.showMessageDialog(this,  "le nombre de bateaux est atteint "," Attention ",JOptionPane.WARNING_MESSAGE);
										}
											}
						}
			

			//la destruction des bateaux

				if(!joueur_actif){
				c = (Case) e.getSource();
				System.out.println(c.getId_case() + " " + c.getI() + " " + c.getJ());
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


			