package org.jzy3d.maths;


public class PolygonArray{
	public PolygonArray(double x[], double y[], double z[]){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int length(){
		return x.length;
	}
	
	public Coord3d getBarycentre(){
		if(barycentre==null)
			barycentre = new Coord3d( Statistics.mean(x), Statistics.mean(y), Statistics.mean(z) );
		return barycentre;
	}
	
	public double x[];
	public double y[];
	public double z[];
	protected Coord3d barycentre;
}
