import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Utilisateur{
	
	int id , nbr_bat;
	String nom;
	Grille g;
	
	public Utilisateur(int id, int nbr_bat) {
		super();
		g = new Grille();
		this.id = id;
											}

}
