package org.jzy3d.maths;

import java.util.Arrays;
import java.util.List;

/**
 * A simple utility class for storing a list of x, y, and z coordinates as
 * arrays of double values.
 * 
 * @author Martin Pernollet
 */
public class Coordinates {
    /** Initialize a list of coordinates with X, Y, and Z values */
    public Coordinates(double[] x, double[] y, double[] z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** Initialize a Grid with a list of coordinates values */
    public Coordinates(Coord3d[] coords) {
        this(Arrays.asList(coords));
    }

    /**
     * 
     * @param coord1
     * @param coords
     */
    public Coordinates(Coord3d coord1, Coord3d... coords) {

        x = new double[coords.length + 1];
        y = new double[coords.length + 1];
        z = new double[coords.length + 1];

        x[0] = coord1.x;
        y[0] = coord1.y;
        z[0] = coord1.z;

        int k = 1;

        for (Coord3d coord : coords) {
            x[k] = coord.x;
            y[k] = coord.y;
            z[k] = coord.z;
            k++;
        }
    }

    /** Initialize a Grid with a list of coordinates values */
    public Coordinates(List<Coord3d> coords) {
        x = new double[coords.size()];
        y = new double[coords.size()];
        z = new double[coords.size()];

        for (int i = 0; i < coords.size(); i++) {
            x[i] = coords.get(i).x;
            y[i] = coords.get(i).y;
            z[i] = coords.get(i).z;
        }
    }

    /** Return the array of X values. */
    public double[] getX() {
        return x;
    }

    /** Return the array of Y values. */
    public double[] getY() {
        return y;
    }

    /** Return the array of Z values. */
    public double[] getZ() {
        return z;
    }

    /** Return the array of 3d coordinates. */
    public Coord3d[] toArray() {
        Coord3d[] array = new Coord3d[x.length];

        for (int i = 0; i < x.length; i++)
            array[i] = new Coord3d(x[i], y[i], z[i]);
        return array;
    }

    /** Return the array of 3d coordinates. */
    @Override
    public String toString() {
        String txt = "";

        for (int i = 0; i < x.length; i++) {
            if (i > 0)
                txt += "\n";
            txt += "[" + i + "] " + x[i] + " | " + y[i] + " | " + z[i];
        }
        return txt;
    }

    /*************************************************************/

    private double[] x;
    private double[] y;
    private double[] z;
}
