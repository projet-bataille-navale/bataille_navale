
abstract class Navire {

	int id , nbr_case;
	String nom;

	public Navire(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbr_case() {
		return nbr_case;
	}

	public void setNbr_case(int nbr_case) {
		this.nbr_case = nbr_case;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
