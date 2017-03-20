package Graphe;

public class Coordonees {

	//vector (x,y)
	private double x;
	private double y;
	private double z;
	private double t;
 
 
	public Coordonees(double x, double t){
		this.x=x;
		this.t=t;
		this.y=0;
		this.z=0;
	}
 
	public Coordonees(double x, double y, double z, double t){
		this.x=x;
		this.y=y;
		this.z=z;
		this.t=t;
	}
	
	public double getX(){
		return this.x;
	}
 
	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}
	
	public double getT(){
		return this.t;
	}
}
