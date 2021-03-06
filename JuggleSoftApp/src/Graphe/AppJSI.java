package Graphe;

import java.util.ArrayList;
import java.util.Enumeration;

import appJS.CONSTANTES;
import appJS.ConnectSerialPort;
import appJS.Point;
import gnu.io.CommPortIdentifier;

public class AppJSI {
	
	public static ArrayList<Point> points = new ArrayList<Point>();

	public static String coulorLEDtoLight = CONSTANTES.BLEU;

	/**
	 * Main
	 * 
	 * @throws Exception
	 */
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
