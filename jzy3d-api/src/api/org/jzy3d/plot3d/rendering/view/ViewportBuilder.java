package org.jzy3d.plot3d.rendering.view;

import org.jzy3d.plot3d.rendering.canvas.ICanvas;

public class ViewportBuilder {
    public static ViewportConfiguration column(ICanvas canvas, double left, double right){
        return column(canvas.getRendererWidth(), canvas.getRendererHeight(), left, right);
    }
    
    public static ViewportConfiguration column(int width, int height, double left, double right){
        int w = (int)((right-left)*width);
        int h = height;
        int x = (int)(left*width);
        int y = x + w;
        return new ViewportConfiguration(w, h, x, y);
    }

    public static ViewportConfiguration cell(ICanvas canvas, double left, double right, double bottom, double top){
        return cell(canvas.getRendererWidth(), canvas.getRendererHeight(), left, right, bottom, top);
    }
    
    public static ViewportConfiguration cell(int width, int height, double left, double right, double bottom, double top){
        int w = (int)((right-left)*width);
        int h = (int)((top-bottom)*height);
        int x = (int)(left*width);
        int y = (int)(bottom*height);
        return new ViewportConfiguration(w, h, x, y);
    }
}
