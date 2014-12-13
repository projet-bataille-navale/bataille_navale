import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Utilisateur{
	
	int id ;
	String nom;
	Grille g;
	
	public Utilisateur(int id ) {
		super();
		g = new Grille();
		this.id = id;
											}

}
