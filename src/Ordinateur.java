import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class Ordinateur extends Utilisateur{
	int cpt = 0;
	int x , y;
	int indice_bateau;
	
	public Ordinateur(int id) {
		super(id);
		this.nom="Ordinateur";
		desactiver_List();
		while(cpt < nbr_bateaux){
			indice_bateau=(int) (Math.random() * Navire.length);
			bateau=bateau(Navire[indice_bateau]);
			x=(int) (Math.random() * 9) ;
			y=(int) (Math.random() * 9) ;
				if(cases_vides(bateau,x,y)){
					creer_bateau(bateau,x,y);
					cpt++;
					x=0;y=0;
											}	
								}

								}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		desactiver_List();
	}
	
	

}
