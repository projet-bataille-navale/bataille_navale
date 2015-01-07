package Controleur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import Modele.Case;
import Modele.Navire;


public class Ordinateur extends Utilisateur implements ActionListener{
	int cpt = 0 ;
	Random coordonnee = new Random();

	int x=0 , y=0;
	//int indice_bateau_liste =0;

	
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
			while(cpt < 5){
				//indice_bateau_liste= coordonnee.nextInt(3 - 0);
				//bateau=bateau(Navire[indice_bateau_liste]);
				bateau=bateau(Navire[cpt]);
				x= coordonnee.nextInt(9 - 0)  ;
				y= coordonnee.nextInt(9 - 0)  ;
					if(cases_vides(bateau,x,y)){
						creer_bateau(bateau,x,y);
						System.out.println(bateau.getId() +" "+ cpt);
						cpt++;
												}	
									}
		if(cpt == 5){
			g.hide_grille();
								}
			
			}
		
						}
			
	public void detruire(Utilisateur u){
		int x = coordonnee.nextInt(9 - 0)  ;
		int y = coordonnee.nextInt(9 - 0)  ;
		
		Case c = chercher_case(x,y,u);
		Navire n=chercher_bateau(u,c.getId_case());// chercher le bateau dans la memoire !!
		System.out.println(n);
		//tester si la case est deja touchée !!
		
		if(c.isE_case_touchee() ){
			//JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);
			u.touchee = 1;
									}
		else if(n==null && c.isE_case_vide()) {
			c.setE_case_touchee(true);
			c.setBackground(Color.green);
			u.touchee = 0;
		}else if(n!=null){
			u.touchee = detruire_bateau(u,n,c);	
		}
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
			Navire n=chercher_bateau(this,c.getId_case());
			
			//tester si la case est deja touchée !!
			if(c.isE_case_touchee() ){
				JOptionPane.showMessageDialog(this,  "Deja touchée "," Attention ",JOptionPane.WARNING_MESSAGE);		
						}
				
			else if(n==null && c.isE_case_vide()) {
				c.setE_case_touchee(true);
				c.setBackground(Color.green);
				touchee = 0;
			}else{
				touchee = detruire_bateau(this,n,c);	
			}
									}				
												}	
												}