package appJS;

public class PointTest {
	
	public final static Point p = new Point("B1_XYZ:24D36D3::ABC:9D11D14");
		
	public static void main(String[] args) {
		p.parseDataRec();
		System.out.println(p.toString());
	}
	
}
