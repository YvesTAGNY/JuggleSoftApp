package appJS;

public class Point {

	//data recieve of balles
	private String dataRec;
	
	/**
	 * Gyroscope value
	 * */
	private int x;
	private int y;
	private int z;
	
	/**
	 * Value of the accelerometer
	 * */
	private int a;
	private int b;
	private int c;
	
	//ID of the ball
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
	 * cut of data for build data of Point objet
	 * */
	public void parseDataRec(){
		
		//
		String [] decoupe_ = dataRec.split("_");
		idBall = decoupe_[0];
		
		String [] decoupeDP = decoupe_[1].split("::");
		
		String [] decoupeSPG = decoupeDP[0].split(":");
		
		String [] decoupeSPA = decoupeDP[1].split(":");
		
		String [] decoupeG =  decoupeSPG[1].split("D");
		
		String [] decoupeA =  decoupeSPA[1].split("D");
		
		x = Integer.parseInt(decoupeG[0]);
		y = Integer.parseInt(decoupeG[1]);
		z = Integer.parseInt(decoupeG[2]);
		
		a = Integer.parseInt(decoupeA[0]);
		b = Integer.parseInt(decoupeA[1]);
		c = Integer.parseInt(decoupeA[2]);
	}
	
}