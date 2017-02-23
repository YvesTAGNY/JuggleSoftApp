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

		if (points_B1.size() < 4 && points_B2.size() < 4)
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
		System.out.println("-"+index);
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
	public static void firtIndentifier() {

		int i = 0;

		double[] pentesAngles;

		pentesAngles = calculPenteAngle(i);

		while (i < 4) {

			System.out.println(i);	
			System.out.println("p1 "+pentesAngles[0]+" a1 "+pentesAngles[2]);
			System.out.println("p2 "+pentesAngles[1]+" a2 "+pentesAngles[3]);
			
			if (Math.abs(pentesAngles[2]) < (double) 20 || Math.abs(pentesAngles[3]) < (double) 20) {
				pentesAngles = calculPenteAngle(i);
			} 
			else {
				if ((pentesAngles[0] < 0 && pentesAngles[1] > 0) || (pentesAngles[0] > 0 && pentesAngles[1] < 0)) {
					System.out.println("c'est un croisé");
				} else {
					System.out.println("c'est un cercle");
				}
				break;
			}
			if (i >= 4)
				System.out.println("Erreur : données non valide ");
			i = i + 2;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * int nombre_valeurs_B1 = 0; int nombre_valeurs_B2 = 0;
		 * 
		 * while(nombre_valeurs_B1 <= 5 && nombre_valeurs_B2 <= 5){
		 * 
		 * Point balle = new Point("B1_XYZ:24-36-03::ABC:09-11-14");
		 * balle.parseDataRec();
		 * 
		 * if(balle.getIdBall().equals("B1")){ if(nombre_valeurs_B1 <= 5){
		 * points_B1.add(balle); nombre_valeurs_B1++; } } else
		 * if(balle.getIdBall().equals("B2")){ if(nombre_valeurs_B2 <= 5){
		 * points_B2.add(balle); nombre_valeurs_B2++; }
		 * 
		 * }
		 * 
		 * } for(int i=1; i<5;i++){ double pente_B1 = (points_B1.get(i).getY() -
		 * points_B1.get(i-1).getY()) / (points_B1.get(i).getX() -
		 * points_B1.get(i-1).getX()); double pente_B2 =
		 * (points_B2.get(i).getY() - points_B2.get(i-1).getY()) /
		 * (points_B2.get(i).getX() - points_B2.get(i-1).getX());
		 * 
		 * double alpha_B1 = Math.atan(pente_B1); double alpha_B2 =
		 * Math.atan(pente_B2);
		 * 
		 * if(alpha_B1 > (double)20 && alpha_B2 > (double)20){ //c'est un cercle
		 * System.out.println("c'est un cercle"); } else
		 * if((Math.abs(alpha_B1)>20 && Math.abs(alpha_B2)>20) && (alpha_B1<0 ||
		 * alpha_B2<0)){ //c'est un croisé System.out.println("c'est un croisé"
		 * ); } }
		 */
	}
}
