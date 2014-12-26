import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


 class Utilisateur extends JPanel {
	 
		final int nbr_bateaux = 5;
		boolean joueur_actif = false;
		int touchee = -1;
		int id ;
		String nom;
		Grille g;
		Navire bateau;
		int num_bateau = 1;
		boolean detruire = false;
		
		ArrayList<Navire> liste_navire;
		JList<String> List;
		String[] Navire = {"zodiac", "sous_marin", "porte_avion", "cuirasses_furtifs"};
	
	//GRAPHIC

	JPanel panel_bateau;
	
	public Utilisateur(int id ) {

		this.id = id;
		g = new Grille();
		liste_navire = new ArrayList<Navire>();// Liste des navire pour ajouter les navires dans la memoire ou bien les supprimer 
		
		panel_bateau = new JPanel(new FlowLayout());
		List = new JList<String>(Navire);
		panel_bateau.add(List);
		
		this.add(panel_bateau);
		this.add(g);
											}
	
	// teste sur les cases qu'on veut les utiliser pour construire un bateau (tous les cases pour que les navires ne chevauchent pas)
	
	public boolean cases_vides( Navire b , int x , int y ){
		 int tmp = 0;
		 for(Case i : g.grille){
			 
			 if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case ){
				 
				 if(!i.isE_case_vide()){
				// JOptionPane.showMessageDialog(g,  "y'a un autre bateau proche"," Attention ",JOptionPane.WARNING_MESSAGE);
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
	
	void creer_bateau(Navire b, int x, int y) {
		// TODO Auto-generated method stub
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
		
		//detruire un bateau ( methode abstract car on va l'utiliser d'un maniere differente entre un joueur et un ordinateur )
		
	public int detruire_bateau(Navire b, int id,int x, int y){
		 for(Case i : g.grille){	
			 // on test si la case contient un bateau si oui donc la case contient l'id du bateau
				if(i.getI()==x && i.getJ()==y && !i.isE_case_vide() && b.id==i.getId_case()){
					i.setE_bat(true);
					i.setE_case_touchee(true);
					i.setBackground(Color.red);
					b.nbr_case--;
					if(b.nbr_case == 0){
						JOptionPane.showMessageDialog(g,"Le "+  b.nom+" est coulé"," Attention ",JOptionPane.WARNING_MESSAGE);
						liste_navire.remove(b);
										}
					return 1;
																}
				else if(i.getI()==x && i.getJ()==y && i.isE_case_vide()){
					i.setE_case_touchee(true);
					i.setBackground(Color.green);
					System.out.println("Radar : ");
					System.out.println(Radar(x,y));
					System.out.println(x);
					System.out.println(y);
					return 0;
					
																		}
				
								
								}
		return -1;	 
	 															}
		
		// comme un declencheur pour manipuler les deux joueurs si le joueur actif c'est a lui de construire les bateaux ou bien les detruire s'il est desactiver il doit attendre son role
		
		public boolean isjoueur_actif() {
			return joueur_actif;
		}

		public  void setjoueur_actif(boolean activer_joueur) {
			this.joueur_actif = activer_joueur;
		}
		
		public int Radar(int h, int z){
			int dif_x=0;
			int dif_y=0;
			int min =1000;
			int res=0;
			 for(Case i:g.grille){				
				 if(i.getId_case()!=-1){
					 dif_x=Math.abs(h-i.getX());
					 dif_y=Math.abs(z-i.getY());
					 res=dif_x+dif_y;
					 if(min>=res)
						 min=res;
				// System.out.println(i.getId_case());
				 }
				 }
		return min;
		}
		
		 
		
}