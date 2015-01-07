import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


//Class Test pour le premier interface
public class La_une implements ActionListener {

	private JFrame frame;
		PanelImage pnl_img;
		private JButton btn_1j;
		private JButton btn_2j;
		private JButton btn_demo;
		private JButton btn_q;
	
	 
	public La_une() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 100,1300, 800);
		pnl_img = new PanelImage();
		pnl_img.setBounds(0, 0,1282, 755);
		frame.getContentPane().add(pnl_img);
		 frame.setVisible(true);
		try {
			pnl_img.setImage("bn.jpg");
			pnl_img.setLayout(null);
			
			btn_1j = new JButton("Un Joueur");
			btn_1j.setForeground(Color.ORANGE);
			btn_1j.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			btn_1j.setBounds(917, 430, 257, 45);
			btn_1j.addActionListener(this);
			pnl_img.add(btn_1j);
			
			btn_1j.setContentAreaFilled(false);
			
			btn_2j = new JButton("Deux Joueur");
			btn_2j.setForeground(Color.ORANGE);
			btn_2j.setBounds(917, 517, 257, 45);
			btn_2j.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			btn_2j.setContentAreaFilled(false);
			pnl_img.add(btn_2j);
			
			btn_demo = new JButton("Mode Démo");
			btn_demo.setForeground(Color.ORANGE);
			btn_demo.setBounds(917, 600, 257, 45);
			btn_demo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			btn_demo.setContentAreaFilled(false);
			pnl_img.add(btn_demo);
			
			btn_q = new JButton("Quitter");
			 
			btn_q.setForeground(Color.ORANGE);
			btn_q.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			btn_q.setContentAreaFilled(false);
			btn_q.setBounds(917, 685, 257, 45);
			pnl_img.add(btn_q);
			
			JLabel lblBatailleNavalle = new JLabel("Bataille Navalle");
			lblBatailleNavalle.setFont(new Font("Algerian", Font.ITALIC, 38));
			lblBatailleNavalle.setBounds(0, 0, 486, 84);
			pnl_img.add(lblBatailleNavalle);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		if(source==btn_1j){
			frame.dispose();
			//Joueur_Ordinateur jo = new Joueur_Ordinateur();
			  new Joueur_Joueur();
		}
		
	}
}
