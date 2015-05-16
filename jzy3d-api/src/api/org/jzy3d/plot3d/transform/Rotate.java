package org.jzy3d.plot3d.transform;

import javax.media.opengl.GL;

import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.rendering.compat.GLES2CompatUtils;

/**
 * Rotate is a {@link Transformer} that stores the angle and rotate values
 * required to perform the effective OpenGL rotation in the ModelView matrix.
 * 
 * @author Martin Pernollet
 */
public class Rotate implements Transformer {

	/**
	 * Initialize a Rotation.
	 * 
	 * @param angle
	 * @param rotate
	 */
	public Rotate(double angle, Coord3d rotate) {
		this.angle = angle;
		this.rotate = rotate;
	}


	@Override
    public void execute(GL gl) {
		if (gl.isGL2()) {
			gl.getGL2().glRotated(angle, rotate.x, rotate.y, rotate.z);
		} else {
			GLES2CompatUtils.glRotatef((float)angle, (float)rotate.x, (float)rotate.y, (float)rotate.z);
		}
	}

	@Override
    public Coord3d compute(Coord3d input) {
		return input.rotate(angle, rotate);
	}

	@Override
    public String toString() {
		return "(Rotate)a=" + angle + " " + rotate;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Coord3d getRotate() {
		return rotate;
	}

	public void setRotate(Coord3d rotate) {
		this.rotate = rotate;
	}

	private double angle;
	private Coord3d rotate;
}
