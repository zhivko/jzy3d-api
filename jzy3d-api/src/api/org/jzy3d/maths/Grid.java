package org.jzy3d.maths;

public class Grid {
	public Grid(){		
	}
	
	public Grid(double[]x, double[]y, double[][] z){
		setData(x, y, z);
	}
	
	public Grid(int[]x, int[]y, int[][] z){
		setData(x, y, z);
	}
	
	/*********************************************/
	
	public void setData(double[]x, double[]y, double[][] z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setData(int[]x, int[]y, int[][] z){
		this.x = toFloatArray( x );
		this.y = toFloatArray( y );
		this.z = toFloatArray( z );
	}
	
	public double[] getX() {
		return x;
	}

	public double[] getY() {
		return y;
	}

	public double[][] getZ() {
		return z;
	}
	
	public BoundingBox3d getBounds(){
		if( bounds == null ){
			bounds = new BoundingBox3d( Statistics.min( x ), Statistics.max( x ),
					 					Statistics.min( y ), Statistics.max( y ),
					 					Statistics.min( z ), Statistics.max( z ) );
		}
		return bounds;
	}
	
	/*********************************************/
	
	protected double[] toFloatArray(int[] input){
		double[] out = new double[input.length];		
		for (int i = 0; i < input.length; i++)
			out[i] = input[i];
		return out;
	}
	
	protected double[][] toFloatArray(int[][] input){
		double[][] out = new double[input.length][input[0].length];
		
		for (int i = 0; i < input.length; i++)
			for (int j = 0; j < input[i].length; j++)
				out[i][j] = input[i][j];
		return out;
	}
	
	protected double[]x;
	protected double[]y;
	protected double[][] z;
	
	protected BoundingBox3d bounds;
}
