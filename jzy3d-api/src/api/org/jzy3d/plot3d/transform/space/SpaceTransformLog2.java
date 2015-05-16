package org.jzy3d.plot3d.transform.space;

/**
 * Apply log transform if value is greater than 0 (otherwise return 0).
 * 
 * @author 
 */
public class SpaceTransformLog2 implements SpaceTransform{

	@Override
	public double compute(double value) {
		if(value <= 0) return 0;
		else return log2(value);
	}	
	
	protected double log2(double x) {
        return (Math.log(x) / Math.log(2));
    }
}
