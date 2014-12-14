import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

 abstract class Utilisateur extends JPanel implements ActionListener,ListSelectionListener {
		final int nbr_bateaux = 5;
		boolean joueur_actif;

		int id ;
		String nom;
		Grille g;
		Navire bateau;
		int num_bateau = 1;
		
		JList<String> List;
		ArrayList<Navire> liste_navire;
	
	//GRAPHIC

	JPanel panel_bateau;
	
	public Utilisateur(int id ) {
		this.id = id;
		g = new Grille(id);
		liste_navire = new ArrayList<Navire>();// Liste des navire pour ajouter les navires dans la memoire ou bien les supprimer 
		
		panel_bateau = new JPanel(new FlowLayout());
		String[] Navire = {"zodiac", "sous_marin", "porte_avion", "cuirasses_furtifs"};
		List = new JList<String>(Navire); 
		panel_bateau.add(List);
		
		//ajouter les listeners pour les cases de la grille
		for(Case c : g.grille){
			c.addActionListener(this);
		}
		// listener pour la List graphique
		List.addListSelectionListener(this);
		
		this.add(panel_bateau);
		this.add(g);
											}
	
	// teste sur les cases qu'on veut les utiliser pour construire un bateau (tous les cases pour que les navires ne chevauchent pas)
	
	public boolean cases_vides( Navire b , int x , int y ){
		 int tmp = 0;
		 for(Case i : g.grille){
			 
			 if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case ){
				 
				 if(!i.isE_case_vide()){
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

			if(Navire == "zodiac"){
				 Zodiac z = new Zodiac(num_bateau);
				 liste_navire.add(z);
				 num_bateau++;
				 return z;
				}
			
			else if(Navire == "sous_marin"){
				Sous_marin sm = new Sous_marin(num_bateau);
				liste_navire.add(sm);
				num_bateau++;
				return sm;
				}
			else if(Navire == "porte_avion"){
				Porte_avion pa = new Porte_avion(num_bateau);
				liste_navire.add(pa);
				num_bateau++;
				return pa;
				}
			else if(Navire == "cuirasses_furtifs"){
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
			if(n.getId() == id){
			if(n.id == id){
				return n;
								}
									}
				
									
		}
		return null;
	}
	

	
	//Activer la liste des bateaux
	
	void activer_List(){
		List.setEnabled(true);
							}

	//Desactiver la liste des bateaux

	void desactiver_List(){
		List.setEnabled(false);
							}
	
		//creation du bateau sur la grille (methode abstract car on va l'utiliser d'un maniere differente entre un joueur et un ordinateur )
	
		abstract void creer_bateau(Navire b,int x, int y);
		
		//detruire un bateau ( methode abstract car on va l'utiliser d'un maniere differente entre un joueur et un ordinateur )
		
		abstract void detruire_bateau(Navire b, int id,int x, int y);
		
		// comme un declencheur pour manipuler les deux joueurs si le joueur actif c'est a lui de construire les bateaux ou bien les detruire s'il est desactiver il doit attendre son role
		
		public boolean isjoueur_actif() {
			return joueur_actif;
		}

		public void setjoueur_actif(boolean activer_joueur) {
			this.joueur_actif = activer_joueur;
		}
		
		
		
		
}