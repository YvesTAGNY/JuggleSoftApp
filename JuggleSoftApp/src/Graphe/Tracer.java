package Graphe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tracer extends JFrame {

	public Courbe courbeAcc;
	public Courbe courbeGyr;
	public Courbe courbeModAcc;
	
	JPanel infos = new JPanel();
	
	Label nbBall = new Label( );
	Label V0 = new Label( );
	Label Alpha = new Label( );
	
	Label l1 = new Label("Nombres de balles");
	Label l2 = new Label("| Vo | = ");
	Label l3 = new Label("Angle = ");
	Label l4 = new Label("Rond -> R | Croisé -> B");
	
	Label l5 = new Label("Valeur X,Y et Z du gyroscope en fonction du temps");

	BalleBleu bb = new BalleBleu();
	BalleRouge br = new BalleRouge();
	
	int couleurBalle = 0;
	
	public Tracer() {
		super("Courbe");
		this.setSize(1000, 600);
		setLayout(new GridLayout(4,1));
		this.courbeAcc = new Courbe();
		this.courbeGyr = new Courbe();
		this.courbeModAcc = new Courbe();
		
		this.infos.setLayout(new GridLayout(4,2));
		this.nbBall.setText("3");
		this.V0.setText("00");
		this.Alpha.setText("00");
	}

	public void printCourbe() {
		this.getContentPane().add(this.courbeGyr);
		//this.getContentPane().add(this.l5);
		this.getContentPane().add(this.courbeAcc);
		this.getContentPane().add(this.courbeModAcc);
		this.infos.add(l1);
		this.infos.add(this.nbBall);
		this.infos.add(l2);
		this.infos.add(this.V0);
		this.infos.add(l3);
		this.infos.add(this.Alpha);
		
		this.infos.add(this.l4);
		
		if(couleurBalle == 0){
			this.infos.add(this.br);
			this.infos.remove(this.bb);
		}
		else{
			this.infos.add(this.bb);
			this.infos.remove(this.br);
		}
		
		this.getContentPane().add(this.infos);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
}

//Blue circle poster
class BalleBleu extends JPanel {
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(0,0,30,30);
		g.setColor(c);
	}
}

//Red circle poster
class BalleRouge extends JPanel {
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(0,0,30,30);
		g.setColor(c);
	}
}