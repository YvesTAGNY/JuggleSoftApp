package Graphe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;

import appJS.ConnectSerialPort;
import appJS.Point;
import gnu.io.CommPortIdentifier;
import javafx.scene.layout.Pane;

public class Tracer extends JFrame {

	private Courbe courbeAcc;
	private Courbe courbeGyr;
	private Courbe courbeModAcc;
	private Courbe courbe;
	private Courbe courbe_;
	
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
		
		if(couleurBalle == 0)
			this.infos.add(this.br);
		else
			this.infos.add(this.bb);
		
		this.getContentPane().add(this.infos);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Program started");

		// declaration of port identifier
		CommPortIdentifier port = null;

		// declaration of iterator of port
		Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();

		while (ports.hasMoreElements()) {
			port = (CommPortIdentifier) ports.nextElement();
			if (port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				ConnectSerialPort.log("Port " + port.getName());
			}
		}

		// "creation of the port"
		ConnectSerialPort csp = new ConnectSerialPort();
		// Establishing connection to port
		csp.OpenPort(port.getName());

		Tracer c = new Tracer();

		int temps = 0;
		int modAcc;
		
		while (true) {
			Point point = new Point();
			if (ConnectSerialPort.dataRec != null) {
				point.setDataRec(ConnectSerialPort.dataRec);
				point.parseDataRec();
				ConnectSerialPort.log("dataRec : " + ConnectSerialPort.dataRec);

				Coordonees coord1 =  new Coordonees(point.getX(), point.getY(), point.getZ(), temps);
				Coordonees coord2 =  new Coordonees(point.getA(), point.getB(), point.getC(), temps);
				
				modAcc = (int) Math.sqrt(Math.pow(point.getA(), 2) + Math.pow(point.getB(), 2) + Math.pow(point.getC(), 2));
				Coordonees coord3 =  new Coordonees(modAcc, temps);
				
				//Coordonees coord =  new Coordonees(point.getX(), temps);
				//Coordonees coord =  new Coordonees(point.getY(), temps);
				//Coordonees coord =  new Coordonees(point.getZ(), temps);
				
				c.courbeAcc.ajouterCoord(coord1);
				c.courbeGyr.ajouterCoord(coord2);
				c.courbeModAcc.ajouterCoord(coord3);
			}
			temps = temps + 10;
			Thread.sleep(500);

			c.printCourbe();
		}

	}
}

class BalleBleu extends JPanel {
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(0,0,30,30);
		g.setColor(c);
	}
}

class BalleRouge extends JPanel {
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(0,0,30,30);
		g.setColor(c);
	}
}