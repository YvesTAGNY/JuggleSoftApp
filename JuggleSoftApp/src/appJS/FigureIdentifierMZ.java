package appJS;

import java.util.ArrayList;

public class FigureIdentifierMZ /*MZ=Méthode des zèros*/ {

    public static ArrayList<Point> points_B1 = new ArrayList<Point>();
    public static ArrayList<Point> points_B2 = new ArrayList<Point>();
    static int zeroballe1 = 0;
    static int zeroballe2 = 0;
    
    static int modAcc1;
    static int modAcc2;
    
    public static boolean valuesFull = false;

    /**
     * Sorting of points according to the ball
     */
    public static boolean triPoint(Point p) {

        if (p.getIdBall().equals("B1"))
            points_B1.add(p);
        else
            points_B2.add(p);

        if (points_B1.size() >= 20 && points_B2.size() >= 20)
            valuesFull = true;
        else
            valuesFull = false;

        return valuesFull;
    }
    
    public static void resetPoints(){
        points_B1.clear();
        points_B2.clear();
        zeroballe1 = 0;
        zeroballe2 = 0;
        valuesFull = false;
    }

    public static void identifierZero()
    {
        
        
        for(Point p:points_B1)
        {    
            modAcc1 = (int) Math.sqrt(Math.pow(p.getA(), 2) + Math.pow(p.getB(), 2) + Math.pow(p.getC(), 2));
            System.out.println(modAcc1);
            //ConnectSerialPort.log(""+FGMZ.modAcc1);
            
            if (modAcc1 < CONSTANTES.SEUIL)
            {
                zeroballe1++;
            }
        }
        for(Point p:points_B2)
        {    
            modAcc2 = (int) Math.sqrt(Math.pow(p.getA(), 2) + Math.pow(p.getB(), 2) + Math.pow(p.getC(), 2));
            System.out.println(modAcc2);
            //ConnectSerialPort.log(""+FGMZ.modAcc2);
            if (modAcc2 < CONSTANTES.SEUIL)
            {
                zeroballe2++;
            }
        }
    }
}
