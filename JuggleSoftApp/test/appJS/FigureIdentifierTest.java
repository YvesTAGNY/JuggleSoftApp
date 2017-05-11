package appJS;

import java.util.ArrayList;

public class FigureIdentifierTest {

	public final static Point p1 = new Point("B1_XYZ:24D36D3::ABC:9D11D14");
	public final static Point p2 = new Point("B2_XYZ:86D122D03::ABC:09D11D14");
	public final static Point p3 = new Point("B1_XYZ:12D95D3::ABC:09D11D14");
	public final static Point p4 = new Point("B2_XYZ:7D11D5::ABC:09D11D14");
	public final static Point p5 = new Point("B1_XYZ:2D4D03::ABC:09D11D14");
	public final static Point p6 = new Point("B2_XYZ:54D73D03::ABC:09D11D14");
	public final static Point p7 = new Point("B1_XYZ:24D45D1::ABC:09D11D14");
	public final static Point p8 = new Point("B2_XYZ:44D130D03::ABC:09D11D14");
	public final static Point p9 = new Point("B1_XYZ:44D13D03::ABC:09D1D14");
	
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
		points.add(p9);
		points.add(p9);
		points.add(p9);
	}
	
	public static void main(String[] args) {
		init();
		for(Point p : points){
			p.parseDataRec();
			if(FigureIdentifierMP.triPoint(p)){
				break;
			}
		}
		System.out.println("B1 : " +  FigureIdentifierMP.points_B1);
		System.out.println("B2 : " +  FigureIdentifierMP.points_B2);
		System.out.println("taile B1 : " +  FigureIdentifierMP.points_B1.size() + " taile B2 : " +  FigureIdentifierMP.points_B2.size());
		FigureIdentifierMP.firtIndentifier();
	}

}
