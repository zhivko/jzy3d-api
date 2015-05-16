package org.jzy3d.maths;

/** Storage for a 3 dimensional vector defined by two points.
 * Provide the vector function that returns the vector
 * as a Coord3d, as well as dot product and norm.
 * @author Martin Pernollet
 */
public class Vector3d {

	/** Create a vector, described by two points.*/
	public Vector3d(double x1, double y1, double z1, double x2, double y2, double z2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
	}
	
	/** Create a vector, described by two coordinates.*/
	public Vector3d(Coord3d p1, Coord3d p2){
		x1 = p1.x;
		x2 = p2.x;
		y1 = p1.y;
		y2 = p2.y;
		z1 = p1.z;
		z2 = p2.z;
	}

	/***********************************************************/

	/** Return the vector induced by this set of coordinates.*/
	public Coord3d vector(){
		return new Coord3d(x2-x1, y2-y1, z2-z1);
	}
	
	/**
	 * Compute the dot product between and current and given vector.
	 * 
	 * Reminnd that the dot product is:
	 * <ul>
	 * <li>0 if vectors are perpendicular
	 * <li>
	 * <li>
	 * </ul>
	 * 
	 * @param v input vector
	 * @return the dot product
	 */
	public double dot(Vector3d v){
		Coord3d v1 = vector();
		Coord3d v2 = v.vector();
		return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
	}
	
	/** Computes the vectorial product of the current and the given vector.
	 * The result is a vector defined as a Coord3d, that is perpendicular to
	 * the plan induced by current vector and vector V.*/
	public Coord3d cross(Vector3d v){
		Coord3d v1 = this.vector();
		Coord3d v2 = v.vector();
		Coord3d v3 = new Coord3d();
										  // V1    V2  =  V3
		v3.x = v1.y * v2.z - v1.z * v2.y; // x1    x2     x3  <-
		v3.y = v1.z * v2.x - v1.x * v2.z; // y1 \/ y2     y3
		v3.z = v1.x * v2.y - v1.y * v2.x; // z1 /\ z2     z3
		
		return v3; //TODO: should return a vector! Vector3d(V3, Coord3d.ORIGIN)
	}
	
	/**
	 * Compute the norm of this vector.
	 * @return the norm
	 */
	public double norm(){
		return Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) + Math.pow(z2-z1,2) );
	}
		
	/***********************************************************/
	
	/** Compute the distance between two coordinates.*/
	public double distance(Coord3d c){
		return getCenter().distance(c);
	}
	
	/**Return the central point of this segment.*/
	public Coord3d getCenter(){
		double cx  = (x1+x2)/2;
		double cy  = (y1+y2)/2;
		double cz  = (z1+z2)/2;	
		return new Coord3d(cx, cy, cz);
	}
		
	/***********************************************************/
	
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private double z1;
	private double z2;
}
