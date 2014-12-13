import javax.swing.JButton;



public class Case extends JButton{
	private int id_case,i,j;
	private boolean e_bat, e_case;
	
	public Case(int id_case, int i, int j, boolean e_bat, boolean e_case) {
		super();
		this.id_case = id_case;
		this.i = i;
		this.j = j;
		this.e_bat = e_bat;
		this.e_case = e_case;
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

	public boolean isE_case() {
		return e_case;
	}

	public void setE_case(boolean e_case) {
		this.e_case = e_case;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	

}
