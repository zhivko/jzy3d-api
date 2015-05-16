package org.jzy3d.maths;

/** Storage for a 2 dimensional vector defined by two points.
 * Provide the vector function that returns the vector
 * as a Coord3d, as well as dot product and norm.
 * @author Martin Pernollet
 */
public class Vector2d {

	/** Create a vector, described by two points.*/
	public Vector2d(double x1, double y1, double x2, double y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/** Create a vector, described by two coordinates.*/
	public Vector2d(Coord2d p1, Coord2d p2){
		x1 = p1.x;
		x2 = p2.x;
		y1 = p1.y;
		y2 = p2.y;
	}

	/***********************************************************/

	/** Return the vector induced by this set of coordinates.*/
	public Coord2d vector(){
		return new Coord2d(x2-x1, y2-y1);
	}
	
	/**
	 * Compute the dot product between and current and given vector.
	 * @param v input vector
	 * @return the dot product
	 */
	public double dot(Vector2d v){
		Coord2d v1 = vector();
		Coord2d v2 = v.vector();
		return v1.x*v2.x + v1.y*v2.y;
	}
	
	/**
	 * Compute the norm of this vector.
	 * @return the norm
	 */
	public double norm(){
		return (double)Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );
	}
		
	/***********************************************************/
	
	private double x1;
	private double x2;
	private double y1;
	private double y2;
}
