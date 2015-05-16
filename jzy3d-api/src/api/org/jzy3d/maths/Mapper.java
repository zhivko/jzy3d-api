package org.jzy3d.maths;

/** 
 * A Mapper provides an abstract definition of a function that allows
 * getting a Z value according to a pair of (X,Y) coordinates.
 * It moreover provide the service of gathering input and computed output
 * into a {@link Coordinates} object, that provides arrays of 
 * X,Y, and Z coordinates as float values.
 * 
 * {@link Mapper} is deprecated. One should use {link net.masagroup.jzy3d.plot3d.builder.Mapper} instead
 */
@Deprecated
public abstract class Mapper {
	/** 
	 * Return an array of Z values according to the implemented function
	 * that provides an output according to an array of (X,Y) coordinates.
	 * */
	public abstract double[] getZ(double[][] xy);
	
	/** 
	 * Return a Z value according to the implemented function
	 * that provides an output according to an (X,Y) coordinates.
	 * */
	public abstract double getZ(double[] xy);
	
	/*****************************************************************************/
	
	/** 
	 * Return a structure containing X, Y, and Z coordinates as arrays of float.
	 */
	public Coordinates getCoordinates(double[][] xy){
		double[] zd = getZ(xy);
		
		double [] x = new double[xy.length];
		double [] y = new double[xy.length];
		double [] z = new double[xy.length];
		
		for(int m=0; m<xy.length; m++){
			x[m] = xy[m][0];
			y[m] = xy[m][1];
			z[m] = zd[m];
		}

		return new Coordinates(x, y, z);
	}
	
	/** 
	 * Return a structure containing X, Y, and Z coordinates as arrays of float.
	 */
	public Coordinates getCoordinates(float[][] xy){
		double[][] xyd = new double[xy.length][xy[0].length]; 
		
		for(int p=0; p<xy.length; p++)
			for(int d=0; d<xy[0].length; d++)
				xyd[p][d] = xy[p][d];

		return getCoordinates(xyd);
	}
	
	/** 
	 * Return a structure containing X, Y, and Z coordinates as arrays of float.
	 */
	public Coordinates getCoordinates(double[] xy){
		double[] x = new double[1];
		double[] y = new double[1];
		double[] z = new double[1];
		
		x[0] = xy[0];
		y[0] = xy[1];
		z[0] = getZ(xy);
		
		return new Coordinates(x, y, z);
	}

	/** 
	 * Return a structure containing X, Y, and Z coordinates as arrays of float.
	 */
	public Coordinates getCoordinates(float[] xy){
		double[] xyd = new double[xy.length]; 
		
		for(int d=0; d<xy.length; d++)
			xyd[d] = xy[d];

		return getCoordinates(xyd);
	}
	
	/*****************************************************************************/
}
