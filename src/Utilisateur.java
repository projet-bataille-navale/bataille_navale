import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

 abstract class Utilisateur extends JPanel implements ActionListener {
		Navire bateau;
		final int nbr_bateaux = 5;
		boolean joueur_actif;

		int id ;
		String nom;
		Grille g;
		int num_bateau = 1;
		ArrayList<Navire> liste_navire;
	
	//GRAPHIC

	JPanel panel_bateau;
	JButton zodiac;
	JButton sous_marin;
	JButton porte_avion;
	JButton cuirasses_furtifs;
	
	public Utilisateur(int id ) {
		this.id = id;
		g = new Grille();
		liste_navire = new ArrayList<Navire>();
		
		//creation des boutons
		zodiac = new JButton("Zodiac");
		sous_marin = new JButton("Sous_Marin");
		porte_avion = new JButton("Porte_Avion");
		cuirasses_furtifs = new JButton("Cuirasses_Furtifs");	
		panel_bateau = new JPanel(new GridLayout(1,4));
		
		panel_bateau.add(zodiac);
		panel_bateau.add(sous_marin);
		panel_bateau.add(porte_avion);
		panel_bateau.add(cuirasses_furtifs);
		
		zodiac.addActionListener(this);
		sous_marin.addActionListener(this);
		porte_avion.addActionListener(this);
		cuirasses_furtifs.addActionListener(this);
		
		//ajouter les listeners pour les cases de la grille
		for(Case c : g.grille){
			c.addActionListener(this);
		}
		
		this.add(panel_bateau);
		this.add(g);
											}
	
	// teste sur les cases qu'on veut les utiliser pour construire un bateau 
	
	public boolean cases_vides( Navire b , int x , int y ){
		 int tmp = 0;
		 for(Case i : g.grille){
			 
			 if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case ){
				 
				 if(i.isE_case()){
				 JOptionPane.showMessageDialog(g,  "baaa9"," Attention ",JOptionPane.WARNING_MESSAGE);
				 return false;
				 					}
				 y++;
				 tmp++;
			 													}
		 						}
		return true;
															}
	
	//creation du bateau a la memoire
	
	Navire bateau(String Navire ){

			if(Navire == "Zodiac"){
				 Zodiac z = new Zodiac(num_bateau);
				 liste_navire.add(z);
				 num_bateau++;
				 return z;
				}
			
			else if(Navire == "Sous_Marin"){
				Sous_marin sm = new Sous_marin(num_bateau);
				liste_navire.add(sm);
				num_bateau++;
				return sm;
				}
			else if(Navire == "Porte_Avion"){
				Porte_avion pa = new Porte_avion(num_bateau);
				liste_navire.add(pa);
				num_bateau++;
				return pa;
				}
			else if(Navire == "Cuirasses_Furtifs"){
				Cuirasses_furtifs cf = new Cuirasses_furtifs(num_bateau);
				liste_navire.add(cf);
				num_bateau++;
				return cf;
				}
			else
				return null;
									}
	
	//chercher un bateau dans la list
	
	Navire chercher_bateau(int id){
		for(Navire n : liste_navire){
			if(n.id == id){
				return n;
								}
									}
				return null;
									}

	
	//Activer les bouton des bateaux
	
	void activer_buttons(){
		zodiac.setEnabled(true);
		sous_marin.setEnabled(true);
		cuirasses_furtifs.setEnabled(true);
		porte_avion.setEnabled(true);
							}
	
	//Désactiver les bouton des bateaux
	
	void desactiver_buttons(){
		zodiac.setEnabled(false);
		sous_marin.setEnabled(false);
		cuirasses_furtifs.setEnabled(false);
		porte_avion.setEnabled(false);
							}
	
		//creation du bateau sur la grille
	
		abstract void creer_bateau(Navire b,int x, int y);
		
		//detruire un bateau
		
		abstract int detruire_bateau(Navire b, int id,int x, int y);
		
		public boolean isjoueur_actif() {
			return joueur_actif;
		}

		public void setjoueur_actif(boolean activer_joueur) {
			this.joueur_actif = activer_joueur;
		}
}
