package org.jzy3d.plot3d.primitives.axes;

import javax.media.opengl.GL;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.rendering.compat.GLES2CompatUtils;

public class AxeLineAnnotation {
    protected Color color = Color.RED;
    protected float width = 3;

    public AxeLineAnnotation() {
        super();
    }

    public void drawVerticalLineGLES2(Range yrange, double value) {
        GLES2CompatUtils.glBegin(GL.GL_LINE_STRIP);
        GLES2CompatUtils.glLineWidth(width);
        GLES2CompatUtils.glColor4f(color.r, color.g, color.b, color.a);
        GLES2CompatUtils.glVertex3f((float)value, (float)yrange.getMin(), 0);
        GLES2CompatUtils.glVertex3f((float)value, (float)yrange.getMax(), 0);
        GLES2CompatUtils.glEnd();
    }

    public synchronized void drawVerticalLineGL2(GL gl, Range yrange, double value) {
        gl.getGL2().glLineWidth(width);
        gl.getGL2().glBegin(GL.GL_LINE_STRIP);
        gl.getGL2().glColor4f(color.r, color.g, color.b, color.a);
        gl.getGL2().glVertex3d(value, yrange.getMin()-yrange.getRange()/30, 0);
        gl.getGL2().glVertex3d(value, yrange.getMax()+yrange.getRange()/30, 0);
        gl.getGL2().glEnd();
    }
    
    public void drawHorizontalLineGLES2(Range xrange, double value) {
        GLES2CompatUtils.glBegin(GL.GL_LINE_STRIP);
        GLES2CompatUtils.glLineWidth(width);
        GLES2CompatUtils.glColor4f(color.r, color.g, color.b, color.a);
        GLES2CompatUtils.glVertex3f((float)xrange.getMin(), (float)value, 0);
        GLES2CompatUtils.glVertex3f((float)xrange.getMax(), (float)value, 0);
        GLES2CompatUtils.glEnd();
    }

    public synchronized void drawHorizontalLineGL2(GL gl, Range xrange, double value) {
        gl.getGL2().glLineWidth(width);
        gl.getGL2().glBegin(GL.GL_LINE_STRIP);
        gl.getGL2().glColor4f(color.r, color.g, color.b, color.a);
        gl.getGL2().glVertex3d(xrange.getMin()-xrange.getRange()/30, value, 0);
        gl.getGL2().glVertex3d(xrange.getMax()+xrange.getRange()/30, value, 0);
        gl.getGL2().glEnd();
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}