import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Joueur extends Utilisateur{
	int cpt , touche = -1 ;//cpt = compteur pour construire les bateaux
	Case c;
	boolean b=true , detruire=false ;

	

	public Joueur(int id ) {
		super(id);
		this.nom="Joueur";
							}
	
		//creation du bateau sur la grille
		
		public void creer_bateau(Navire b,int x, int y){
			int tmp =0;			
			for(Case i : g.grille){
				
				if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case && !i.isE_case() ){
					i.setId_case(b.id);
					i.setE_case(true);
					i.setBackground(Color.GRAY);			 
					y++;
					tmp++;
																					}
								
								}
	 												}
		
		//
		public int detruire_bateau(Navire b, int id,int x, int y){
			 for(Case i : g.grille){	
					if(i.getI()==x && i.getJ()==y&& i.isE_case() && b.id==i.getId_case()){
						i.setE_bat(true);
						i.setBackground(Color.red);
						i.setEnabled(false);
						b.nbr_case--;
						if(b.nbr_case == 0){
							JOptionPane.showMessageDialog(g,"Le "+  b.nom+" est coulé"," Attention ",JOptionPane.WARNING_MESSAGE);
							liste_navire.remove(b);
							b.nbr_case = -1;
											}
						return 1;
																	}
					
									
									}
			return 0;		 
		 															}

		//
		public void actionPerformed(ActionEvent e) {
			if(joueur_actif){
			if(b && !detruire){
			activer_buttons();
			String Navire = ((JButton) e.getSource()).getText();
			desactiver_buttons();
			g.activer_grille();
			bateau=bateau(Navire);
			b=false;
								}
			
			else if(!b){
			c = (Case) e.getSource();
			//construction des bateaux
			if (cpt < nbr_bateaux ){
				if(c.isE_case()){
				JOptionPane.showMessageDialog(this,  "la case est deja remplie !"," Attention ",JOptionPane.WARNING_MESSAGE);
								}	
				else if(cases_vides(bateau,c.getI(),c.getJ())){
					creer_bateau(bateau,c.getI(),c.getJ());
					activer_buttons();
					g.desactiver_grille();
					cpt++;
					b=true;
																}
				
			//si le nombre de bateaux est atteint le message se déclenche
			if(cpt == nbr_bateaux){
					desactiver_buttons();
					g.hide_grille();
					joueur_actif=false;
					detruire = true;
					JOptionPane.showMessageDialog(this,  "le nombre de bateaux est atteint "," Attention ",JOptionPane.WARNING_MESSAGE);
									}
								}
						}
			
			//la destruction des bateaux
			else if(detruire && b){
				//g.activer_grille();
				c = (Case) e.getSource();
				Navire n=chercher_bateau(c.getId_case());
				if(cpt == nbr_bateaux){
					if(c.getId_case()==-1){
						c.setBackground(Color.green);
						c.setEnabled(false);
						touche=0;
											}
					else{
					touche=detruire_bateau(n,c.getId_case(),c.getI(),c.getJ());
						}
										}
								}
			if(liste_navire.isEmpty()){
				JOptionPane.showMessageDialog(this,  "Félicitation !! vous avez gagné !!"," Attention ",JOptionPane.WARNING_MESSAGE);	
			}
			}
		}
			

}
