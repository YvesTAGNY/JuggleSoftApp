package App;

public class Point {

	//data recieve of balle
	private String dataRec;
	
	/**
	 * valeur du gyroscope
	 * */
	private int x;
	private int y;
	private int z;
	
	/**
	 * valeur de l'acc�lerometre
	 * */
	private int a;
	private int b;
	private int c;
	
	//identifiant de la balle
	private String idBall;
	
	/**
	 * Constructeurs
	 * */
	
	Point(){}
	
	Point(String dataRec){
		this.dataRec = dataRec;
	}
	
	/**
	 * Getter and setter
	 * */
	
	public String getDataRec() {
		return dataRec;
	}


	public void setDataRec(String dataRec) {
		this.dataRec = dataRec;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}


	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public int getC() {
		return c;
	}


	public void setC(int c) {
		this.c = c;
	}


	public String getIdBall() {
		return idBall;
	}


	public void setIdBall(String idBall) {
		this.idBall = idBall;
	}
	
	//Overide of method toString
	public String toString(){
		return "ID bale : " + idBall +  "| x = " + x + "| y = " + y + "| z = " + z + "| a = " + a + "| b = " + b + "| c = " + c;
	}
	
	/**
	 * cut of data for build data of Point obje
	 * */
	public void parseDataRec(){
		
		//
		String [] decoupe_ = dataRec.split("_");
		idBall = decoupe_[0];
		
		String [] decoupeDP = decoupe_[1].split("::");
		
		String [] decoupeSPG = decoupeDP[0].split(":");
		
		String [] decoupeSPA = decoupeDP[1].split(":");
		
		String [] decoupeG =  decoupeSPG[1].split("-");
		
		String [] decoupeA =  decoupeSPA[1].split("-");
		
		x = Integer.parseInt(decoupeG[0]);
		y = Integer.parseInt(decoupeG[1]);
		z = Integer.parseInt(decoupeG[2]);
		
		a = Integer.parseInt(decoupeA[0]);
		b = Integer.parseInt(decoupeA[1]);
		c = Integer.parseInt(decoupeA[2]);
	}
	
	public static void main(String[] args) throws Exception {
		Point p = new Point("B1_XYZ:24-36-03::ABC:09-11-14");
		p.parseDataRec();
		System.out.println(p.toString());
	}
	
}