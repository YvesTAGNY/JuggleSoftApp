package appJS;

import java.util.ArrayList;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class AppJS {

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

		//"creation of the port"
		ConnectSerialPort csp = new ConnectSerialPort();
		//Establishing connection to port
		csp.OpenPort(port.getName());

		/*
		 * //test d'envoi des couleur while(true){ ConnectSerialPort.log("Send "
		 * + CONSTANTES.BLEU);
		 * sp.getSerialOut().write(CONSTANTES.BLEU.getBytes());
		 * Thread.sleep(1000); ConnectSerialPort.log("Send " +
		 * CONSTANTES.ROUGE);
		 * sp.getSerialOut().write(CONSTANTES.ROUGE.getBytes());
		 * Thread.sleep(1000); }
		 */
		
		/**make aquisition traitement and result*/
		while(true){
			//Recovering of 12 points : 1 every 1 second
			while (points.size() < 8) {
				Point point = new Point();
				if (ConnectSerialPort.dataRec != null) {
					point.setDataRec(ConnectSerialPort.dataRec);
					point.parseDataRec();
					ConnectSerialPort.log("dataRec : " + ConnectSerialPort.dataRec);
					points.add(point);
				}
				Thread.sleep(500);
			}
			
			//Sorting points
			for (Point p : points) {
				if (FigureIdentifier.triPoint(p)) {
					break;
				}
			}
	
			//Identification as a function of slope values
			System.out.println();
			System.out.println("taile B1 : " + FigureIdentifier.points_B1.size() + " taile B2 : " + FigureIdentifier.points_B2.size());
			coulorLEDtoLight = FigureIdentifier.firtIndentifier();
			csp.getSerialOut().write(coulorLEDtoLight.getBytes());
			ConnectSerialPort.log("Send coulorLEDtoLight : " + coulorLEDtoLight);
			
			//waiting 10s after a new calcul
			System.out.println();
			System.out.println("Waiting 10 seconds ...");
			
			Thread.sleep(10000);
			points.clear();
			FigureIdentifier.resetPoints();
			
			System.out.println();
			System.out.println("New calcul");
		}
		// System.out.println("Finished successfully");
	}

}
