package appJS;

import java.util.ArrayList;

public class FigureIdentifierTest {

	public final static Point p1 = new Point("B1_XYZ:25-36-03::ABC:09-11-14");
	public final static Point p2 = new Point("B2_XYZ:86-122-03::ABC:09-11-14");
	public final static Point p3 = new Point("B1_XYZ:12-95-3::ABC:09-11-14");
	public final static Point p4 = new Point("B2_XYZ:7-11-5::ABC:09-11-14");
	public final static Point p5 = new Point("B1_XYZ:2-4-03::ABC:09-11-14");
	public final static Point p6 = new Point("B2_XYZ:54-73-03::ABC:09-11-14");
	public final static Point p7 = new Point("B1_XYZ:24-45-1::ABC:09-11-14");
	public final static Point p8 = new Point("B2_XYZ:44-130-03::ABC:09-11-14");
	
	public static ArrayList<Point> points = new ArrayList<Point>();
	
	static void init(){
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);
	}
	
	public static void main(String[] args) {
		init();
		for(Point p : points){
			p.parseDataRec();
			FigureIdentifier.triPoint(p);
		}
		System.out.println("B1 : " +  FigureIdentifier.points_B1);
		System.out.println("B2 : " +  FigureIdentifier.points_B2);
		System.out.println("taile B1 : " +  FigureIdentifier.points_B1.size() + " taile B2 : " +  FigureIdentifier.points_B2.size());
		FigureIdentifier.firtIndentifier();
	}

}
