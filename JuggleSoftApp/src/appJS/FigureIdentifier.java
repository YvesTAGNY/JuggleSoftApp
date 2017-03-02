package appJS;

import java.util.ArrayList;

public class FigureIdentifier {

	public static ArrayList<Point> points_B1 = new ArrayList<Point>();
	public static ArrayList<Point> points_B2 = new ArrayList<Point>();

	public static boolean valuesFull = false;

	/**
	 * Sorting of points according to the ball
	 */
	public static boolean triPoint(Point p) {

		if (p.getIdBall().equals("B1"))
			points_B1.add(p);
		else
			points_B2.add(p);

		if (points_B1.size() >= 4 && points_B2.size() >= 4)
			valuesFull = true;
		else
			valuesFull = false;

		return valuesFull;
	}
	
	public static void resetPoints(){
		points_B1.clear();
		points_B2.clear();
		valuesFull = false;
	}
	
	/**
	 * Calculates slopes and angles
	 */
	public static double[] calculPenteAngle(int index) {
		/**
		 * indice 0 = pente_B1; 1= pente_B2; 2= alpha_B1; 3= alpha_B2
		 */
		double[] pentesAngles = new double[4];
		
		if (points_B1.get(index).getX() < points_B1.get(index + 1).getX()) {
			pentesAngles[0] = (points_B1.get(index + 1).getY() - points_B1.get(index).getY())
					/ (points_B1.get(index + 1).getX() - points_B1.get(index).getX());

			pentesAngles[2] = Math.toDegrees(Math.atan(pentesAngles[0]));
		} else {
			pentesAngles[0] = (points_B1.get(index).getY() - points_B1.get(index + 1).getY())
					/ (points_B1.get(index).getX() - points_B1.get(index + 1).getX());

			pentesAngles[2] = Math.toDegrees(Math.atan(pentesAngles[0]));
		}

		if (points_B2.get(index).getX() < points_B2.get(index + 1).getX()) {
			pentesAngles[1] = (points_B2.get(index + 1).getY() - points_B2.get(index).getY())
					/ (points_B2.get(index + 1).getX() - points_B2.get(index).getX());

			pentesAngles[3] = Math.toDegrees(Math.atan(pentesAngles[1]));
		} else {
			pentesAngles[1] = (points_B2.get(index).getY() - points_B2.get(index + 1).getY())
					/ (points_B2.get(index).getX() - points_B2.get(index + 1).getX());

			pentesAngles[3] = Math.toDegrees(Math.atan(pentesAngles[1]));
		}

		return pentesAngles;
	}

	/**
	 * Identified the figure in the first juggling movements
	 */
	public static String firtIndentifier() {

		int i = 0;

		double[] pentesAngles;

		//calcul pente and angle of 2 frist points of 2 balls
		pentesAngles = calculPenteAngle(i);

		while (i < 4) {
			
			ConnectSerialPort.log("Pente et angle balle 1 : "+pentesAngles[0]+" ||| "+pentesAngles[2]);
			ConnectSerialPort.log("Pente et angle balle 1 : "+pentesAngles[1]+" ||| "+pentesAngles[3]);
			
			if (Math.abs(pentesAngles[2]) < (double) 20 || Math.abs(pentesAngles[3]) < (double) 20) {
				//calcul pente and angle of 3rd 4th points of 2 balls
				pentesAngles = calculPenteAngle(i);
			} 
			else {
				if ((pentesAngles[0] < 0 && pentesAngles[1] > 0) || (pentesAngles[0] > 0 && pentesAngles[1] < 0)) {
					ConnectSerialPort.log("La figure de jonglage est un CROISE");
					return CONSTANTES.ROUGE;
				} else {
					ConnectSerialPort.log("La figure de jonglage est un CERCLE");
					return CONSTANTES.BLEU;
				}
			}
			if (i >= 4)
				ConnectSerialPort.log("Erreur : données non valides ");
			i = i + 2;
		}
		return null;
	}
}
