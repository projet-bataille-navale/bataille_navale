import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Grille extends JPanel implements ActionListener {
	
	ArrayList<Case> grille;
	static final int nbr_bateaux = 5;
	int i,j;// les x et les y pour la contruction de la grille
	//Zodiac z = new Zodiac(1);
	int cpt=0,tmp=0;//cpt = compteur pour construire les bateaux / tmp = compteur pour tester si le bateau est coulé
	Navire bateau;
	boolean b=true;
	
	//GRAPHIC
	JPanel panel_grille;
	JPanel panel_bateau;
	JButton zodiac;
	JButton sous_marin;
	JButton porte_avion;
	JButton cuirasses_furtifs;
	JList liste = new JList();
	
		
	//il reste le nombre de bateaux pour l'entrer a la grille
	
	 public Grille() {

	    zodiac = new JButton("Zodiac");
		sous_marin = new JButton("Sous_Marin");
		porte_avion = new JButton("Porte_Avion");
		cuirasses_furtifs = new JButton("Cuirasses_Furtifs");	
		
		panel_grille = new JPanel( new GridLayout(10, 10) );
		panel_bateau = new JPanel(new GridLayout(1,4));

		grille = new ArrayList<Case>();
		for(i=0; i<10; i++){
			for(j=0; j<10; j++){
					grille.add(new Case(-1,i,j,false,false));			  
								}
							}
		
		for(Case y : grille){
						y.setBackground(Color.WHITE);
						y.setEnabled(false);
						panel_grille.add(y);
						y.addActionListener(this);		
							}
		panel_bateau.add(zodiac);
		panel_bateau.add(sous_marin);
		panel_bateau.add(porte_avion);
		panel_bateau.add(cuirasses_furtifs);
		
		zodiac.addActionListener(this);
		sous_marin.addActionListener(this);
		porte_avion.addActionListener(this);
		cuirasses_furtifs.addActionListener(this);
		
		this.add(panel_bateau);
		this.add(panel_grille);
									}
			
	 // teste sur les cases qu'on veut les utiliser pour construire un bateau 
	 public boolean cases_vides(Navire b , int x , int y ){
		 int tmp = 0;
		 for(Case i : grille){
			 
			 if(i.getI()==x && i.getJ()==y && tmp<b.nbr_case ){
				 
				 if(i.isE_case()){
				 JOptionPane.showMessageDialog(this,  "baaa9"," Attention ",JOptionPane.WARNING_MESSAGE);
				 return false;
				 					}
				 y++;
				 tmp++;
			 													}
			 
		 					}
		return true;
	 														}
	 
	 
	 public void creer_bateau(Navire b,int x, int y){
			int tmp =0;			
			for(Case i : grille){
				
				if(i.getI()==x && i.getJ()==y && tmp<=b.nbr_case && !i.isE_case() ){
					i.setId_case(b.id);
					System.out.println(b.id);
					i.setE_case(true);
					i.setBackground(Color.GRAY);			 
					y++;
					tmp++;
																						}
								
								}
	 												}
	 
	 public void detruire_bateau(Navire b,int id,int x, int y){

		 for(Case i : grille){	
				if(i.getI()==x && i.getJ()==y&& i.isE_case() && id==i.getId_case()){
					i.setE_bat(true);
					i.setBackground(Color.red);
					//b.nbr_case--;
					System.out.println(tmp+" id_bateau:"+b.id+"  id_case:"+id);
					tmp++;
																}
				else if(i.getI()==x && i.getJ()==y&& !i.isE_case()){
					i.setBackground(Color.green);
					i.setEnabled(false);
				}
				if(b.nbr_case==tmp && id==b.id){
					JOptionPane.showMessageDialog(this,  "le bateau "+ b.id+" est coulé"," Attention ",JOptionPane.WARNING_MESSAGE);
					tmp=0;
											}
								
								}		 
	 											}
	 
	 		Navire bateau(String Navire){
	 			if(Navire == "Zodiac"){
	 				 Zodiac z = new Zodiac(1);
	 				 return z;
	 				}
	 			
	 			else if(Navire == "Sous_Marin"){
	 				Sous_marin sm = new Sous_marin(2);
	 				return sm;
	 				}
	 			else if(Navire == "Porte_Avion"){
	 				Porte_avion pa = new Porte_avion(3);
	 				return pa;
	 				}
	 			else if(Navire == "Cuirasses_Furtifs"){
	 				Cuirasses_furtifs cf = new Cuirasses_furtifs(4);
	 				return cf;
	 				}
	 			else
					return null;
	 									}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(b){
		String Navire = ((JButton) arg0.getSource()).getText();
		activer_grille();
		bateau=bateau(Navire);
		b=false;
		}
		
		else if(!b){
		Case c = (Case) arg0.getSource();
		System.out.println(c.getId_case());
		//la destruction des bateaux
		if(cpt==nbr_bateaux){
				detruire_bateau(bateau,c.getId_case(),c.getI(),c.getJ());											
					}	
		
		//construction des bateaux
		if (cpt < nbr_bateaux ){
		boolean v=cases_vides(bateau,c.getI(),c.getJ());	
		
			if(c.isE_case()){
			JOptionPane.showMessageDialog(this,  "la case est deja remplie !"," Attention ",JOptionPane.WARNING_MESSAGE);
							}		
			else if(v){
				creer_bateau(bateau,c.getI(),c.getJ());
				desactiver_grille();
				cpt++;
				b=true;
						}
			//si le nombre de bateaux est atteint le message se déclenche
		if(cpt == nbr_bateaux){
				desactiver_buttons();
				activer_grille();
				JOptionPane.showMessageDialog(this,  "le nombre de bateaux est atteint "," Attention ",JOptionPane.WARNING_MESSAGE);
								}
						}
		}
													}
	
		void activer_grille(){
			for(Case y : grille){
				y.setEnabled(true);		
								}
							}
		
		void desactiver_grille(){
			for(Case y : grille){
				y.setEnabled(false);		
								}
								}
		
		void desactiver_buttons(){
			zodiac.setEnabled(false);
			sous_marin.setEnabled(false);
			cuirasses_furtifs.setEnabled(false);
			porte_avion.setEnabled(false);
								}
								

													}
	
	
		