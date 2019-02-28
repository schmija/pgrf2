package imageData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestVisibility {
    private ImageBuffer imageBuffer;
    private DepthBuffer depthBuffer;

    public TestVisibility(BufferedImage image) {
        this.imageBuffer = new ImageBuffer(image);
        depthBuffer = new DepthBuffer(image.getWidth(), image.getHeight());
    }

    public void clear(Color color){
        depthBuffer.clear();
        imageBuffer.clear(color);
    }

    public boolean isVisible(int x, int y, float depth){
        return depthBuffer.getValue(x, y) >= depth;
    }

    public void paint(int x, int y, float depth, int color){
        if (isVisible(x, y, depth)){
            depthBuffer.setValue(x, y, depth);
            imageBuffer.setValue(x, y, color);
        }
    }
}
