package Graphe;

import java.util.ArrayList;

import appJS.CONSTANTES;
import appJS.Point;

public class FigureIdentifierMZ2 {

    public static ArrayList<Point> points_B1 = new ArrayList<Point>();
    public static ArrayList<Point> points_B2 = new ArrayList<Point>();
    
    public static ArrayList<Integer> t_B1EnAir = new ArrayList<Integer>();
    public static ArrayList<Integer> t_B2EnAir = new ArrayList<Integer>();
    
    static int zeroballe1 = 0;
    static int zeroballe2 = 0;
    
    static int modAcc1;
    static int modAcc2;
    
    public static boolean balle1EnAir = false;
    public static boolean balle2EnAir = false;
    public static boolean valuesFull = false;
    
    public static String colorBalles ;

    /**
     * Sorting of points according to the ball
     */
    public static void calculZero(Point p) {

        if (p.getIdBall().equals("B1")){
            points_B1.add(p);
	        if(ModAcc(p.getA(),p.getB(),p.getC()) <= CONSTANTES.SEUIL){
	        	balle1EnAir = true;
	        	zeroballe1 ++;
	        }
	        else{
	        	balle1EnAir =false;
	        	t_B1EnAir.add(zeroballe1);
	        	zeroballe1 = 0;
	        }
        }	
        else{
            points_B2.add(p);
            if(ModAcc(p.getA(),p.getB(),p.getC()) <= CONSTANTES.SEUIL){
            	balle2EnAir = true;
            	zeroballe2 ++;
            }
            else{
            	balle2EnAir =false;
            	t_B2EnAir.add(zeroballe2);
            	zeroballe2 = 0;
            }
            	
        }

        if(t_B1EnAir.size() >= 3 || t_B2EnAir.size() >= 3){
        	colorBalles = IdendifierZero2();
        	reset();
        }
    }
    
    public static String IdendifierZero2() {
    	
    	int v11, v12, v13, v21, v22, v23;
    	
    	v11 = Math.abs(t_B1EnAir.get(0) - t_B1EnAir.get(1));
    	v12 = Math.abs(t_B1EnAir.get(0) - t_B1EnAir.get(2));
    	v13 = Math.abs(t_B1EnAir.get(1) - t_B1EnAir.get(2));
    	
    	v21 = Math.abs(t_B2EnAir.get(0) - t_B2EnAir.get(1));
    	v22 = Math.abs(t_B2EnAir.get(0) - t_B2EnAir.get(2));
    	v23 = Math.abs(t_B2EnAir.get(1) - t_B2EnAir.get(2));
    	
    	if(v21 <= 3 || v22 <=3 || v23 <=3){
    		return CONSTANTES.ROUGE;
    	}
    	else{
    		return CONSTANTES.BLEU;
    	}
		
    }
    
    public static int ModAcc(int A, int B, int C)
    {  
    	return modAcc2 = (int) Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));
    }
    
    public static void reset(){
        points_B1.clear();
        points_B2.clear();
        t_B1EnAir.clear();
        t_B2EnAir.clear();
        zeroballe1 = 0;
        zeroballe2 = 0;
        balle1EnAir = false;
        balle2EnAir = false;
        valuesFull = false;
    }

}
