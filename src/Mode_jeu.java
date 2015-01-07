import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mode_jeu extends JFrame implements ActionListener{
	
	Joueur_Joueur j_j_mode;
	
	JButton j_j;
    JButton j_o;
    JButton o_o;
	JPanel panel_mode ;
	JPanel panel_joueur;
	
	public Mode_jeu(){
		this.setTitle("BATAILLE NAVALE");
		panel_mode = new JPanel(new GridLayout(3,1));
		this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    this.pack();
	    this.setSize(new Dimension(800, 400));
	    j_j = new JButton("Joueur VS Joueur");
	    j_o = new JButton("Joueur VS Ordinateur");
	    o_o = new JButton("Ordinateur VS Ordinateur");
	    j_j.addActionListener(this);
	    panel_mode.add(j_j);
	    panel_mode.add(j_o);
	    panel_mode.add(o_o);
	    this.add(panel_mode);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Joueur VS Joueur"){
			this.dispose();
			j_j_mode = new Joueur_Joueur();
		}
		
	}

}
