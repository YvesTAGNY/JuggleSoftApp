package Graphe;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JFrame;

import appJS.ConnectSerialPort;
import appJS.Point;
import gnu.io.CommPortIdentifier;

public class Tracer extends JFrame {

	private Courbe courbe;

	public Tracer() {
		super("Courbe");
		this.setSize(500, 500);

		this.courbe = new Courbe();

		 this.courbe.ajouterCoord(new Coordonees(5, 6681.8929));
		 this.courbe.ajouterCoord(new Coordonees(10, 11834.3456));
		 this.courbe.ajouterCoord(new Coordonees(20, 37059.7267));
		 this.courbe.ajouterCoord(new Coordonees(30, 32249.5167));
		 this.courbe.ajouterCoord(new Coordonees(40, 11503.6712));
		 this.courbe.ajouterCoord(new Coordonees(50, 7485.3936));
		 this.courbe.ajouterCoord(new Coordonees(60, 5720.6952));
		 this.courbe.ajouterCoord(new Coordonees(70, 4762.9483));
		 this.courbe.ajouterCoord(new Coordonees(80, 4207.3249));
		 this.courbe.ajouterCoord(new Coordonees(90, 3880.5546));

	}

	public void printCourbe() {
		this.getContentPane().add(this.courbe);

		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) throws Exception {

		/*System.out.println("Program started");

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
		csp.OpenPort(port.getName());*/

		Tracer c = new Tracer();

		int temps = 0;

		/*while (true) {
			Point point = new Point();
			if (ConnectSerialPort.dataRec != null) {
				point.setDataRec(ConnectSerialPort.dataRec);
				point.parseDataRec();
				ConnectSerialPort.log("dataRec : " + ConnectSerialPort.dataRec);

				Coordonees coord = new Coordonees(temps, point.getX());
				c.courbe.ajouterCoord(coord);
			}
			temps = temps + 10;
			Thread.sleep(500);*/

			c.printCourbe();
		//}

	}
}