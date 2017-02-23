package appJS;

public class PointTest {
	
	public final static Point p = new Point("B1_XYZ:24-36-03::ABC:09-11-14");
	
	public static void main(String[] args) throws Exception {
		p.parseDataRec();
		System.out.println(p.toString());
	}
}
