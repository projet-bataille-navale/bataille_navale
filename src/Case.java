import javax.swing.JButton;

public class Case extends JButton{
	private int id_case,i,j;
	private boolean e_bat, e_case_vide , e_case_touchee;
	
	public Case(int id_case, int i, int j, boolean e_bat, boolean e_case_vide, boolean e_case_touchee) {
		super();
		this.id_case = id_case;
		this.i = i;
		this.j = j;
		this.e_bat = e_bat;
		this.e_case_vide = e_case_vide;
		this.e_case_touchee = e_case_touchee;
	}

	public boolean isE_case_touchee() {
		return e_case_touchee;
	}

	public void setE_case_touchee(boolean e_case_touchee) {
		this.e_case_touchee = e_case_touchee;
	}

	public int getId_case() {
		return id_case;
	}

	public void setId_case(int id_case) {
		this.id_case = id_case;
	}

	public boolean isE_bat() {
		return e_bat;
	}

	public void setE_bat(boolean e_bat) {
		this.e_bat = e_bat;
	}

	public boolean isE_case_vide() {
		return e_case_vide;
	}

	public void setE_case_vide(boolean e_case_vide) {
		this.e_case_vide = e_case_vide;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	public String toString(){
		return "x: "+i+" y: "+j+ " id: "+id_case;
	}
	

}
