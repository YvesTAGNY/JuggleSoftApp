package Graphe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class Courbe extends JPanel{
	 
	private Vector<Coordonees> listeCoord=new Vector<Coordonees>();
	private double xMin=Double.MAX_VALUE;
	private double yMin=Double.MAX_VALUE;
	private double xMax=Double.MIN_VALUE;
	private double yMax=Double.MIN_VALUE;
 
	private int largeur=0;
	private int hauteur=0;
	private int left=10;
	private int top=10;
 
	public Courbe(){}
 
	public void ajouterCoord(Coordonees p){
		double max = Math.max(Math.max(p.getX(), p.getY()),p.getZ());
		double min = Math.min(Math.min(p.getX(), p.getY()),p.getZ());
		
		if(p.getT()<this.xMin)
			this.xMin=p.getT();
		else if(p.getT()>this.xMax)
			this.xMax=p.getT();
 
		if(min<this.yMin)
			this.yMin=min;
		else if(max>this.yMax)
			this.yMax=max;
 
		this.listeCoord.add(p);
 
		this.repaint();		
	}
 
	public void paint(Graphics g){
		super.paint(g);
 
		//size of panel
		this.largeur=this.getWidth()-20;
		this.hauteur=this.getHeight()-20;
		
		//position of panel in th winsow
		this.left=10;
		this.top=10;
		
		//coulor and forme of zone graphic
		g.setColor(Color.WHITE);
		g.fillRect(this.left, this.top, this.largeur, this.hauteur);
 
		g.setColor(Color.RED);
		if(this.listeCoord.size()==1){
			int x=this.left+(this.largeur/2);
			int y=this.top+(this.hauteur/2);
			g.drawLine(x-2, y, x+2, y);
			g.drawLine(x, y-2, x, y+2);	
		}
		else{
			for(int i=0; i<this.listeCoord.size()-1; i++){
				Coordonees p1=this.convertirPointSurReferenciel(this.listeCoord.get(i));
				Coordonees p2=this.convertirPointSurReferenciel(this.listeCoord.get(i+1));
				int x1=(int)p1.getX();
				int y1=(int)p1.getY();
				int z1=(int)p1.getZ();
				int t1=(int)p1.getT();
				int x2=(int)p2.getX();
				int y2=(int)p2.getY();
				int z2=(int)p2.getZ();
				int t2=(int)p2.getT();
 
				g.setColor(Color.BLACK);
				g.drawLine(10, 10, t2, 10);
				
				g.setColor(Color.BLACK);
				g.drawLine(10, 10, 10, Math.max(Math.max(x2, y2),z2));
				
				//z
				g.setColor(Color.GRAY);
				g.drawLine(t1, z1, t2, z2);
 
				g.setColor(Color.CYAN);
				g.drawLine(t1-3, z1, t1+3, z1);
				g.drawLine(t1, z1-3, t1, z1+3);
				
				//y
				g.setColor(Color.GREEN);
				g.drawLine(t1, y1, t2, y2);
 
				g.setColor(Color.ORANGE);
				g.drawLine(t1-3, y1, t1+3, y1);
				g.drawLine(t1, y1-3, t1, y1+3);
				
				//x
				g.setColor(Color.BLUE);
				g.drawLine(t1, x1, t2, x2);
 
				g.setColor(Color.RED);
				g.drawLine(t1-3, x1, t1+3, x1);
				g.drawLine(t1, x1-3, t1, x1+3);
			}	
 
			Coordonees p1=this.convertirPointSurReferenciel(this.listeCoord.get(this.listeCoord.size()-1));
			int x1=(int)p1.getX();
			int y1=(int)p1.getY();
			int z1=(int)p1.getZ();
			int t1=(int)p1.getT();
			g.drawLine(t1-4, x1, t1+4, x1);
			g.drawLine(t1, x1-4, t1, x1+4);
			
			g.drawLine(t1-4, y1, t1+4, y1);
			g.drawLine(t1, y1-4, t1, y1+4);
			
			g.drawLine(t1-4, z1, t1+4, z1);
			g.drawLine(t1, z1-4, t1, z1+4);
		}		
	}
 
	public Coordonees convertirPointSurReferenciel(Coordonees p){
		double amplitudeX=this.xMax-this.xMin;
		double amplitudeY=this.yMax-this.yMin;
 
		double rapportX=this.largeur/amplitudeX;
		double rapportY=this.hauteur/amplitudeY;
 
		double x=(p.getX()-this.yMin)*rapportY;
		double y=(p.getY()-this.yMin)*rapportY;
		double z=(p.getZ()-this.yMin)*rapportY;
		double t=(p.getT()-this.xMin)*rapportX;
 
		x=this.hauteur-x;
		y=this.hauteur-y;
		z=this.hauteur-z;
 
		x=x+this.top;
		y=y+this.top;
		z=z+this.top;
		t=t+this.left;
 
		return new Coordonees(x,y,z,t);
	}	
}
