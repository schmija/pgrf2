package ImageData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageBuffer implements Image<Integer> {
    private Integer value;
    private BufferedImage image;

    public ImageBuffer(BufferedImage image) {
        this.image = image;
    }

    public void clear(Color color){
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0,0, image.getWidth(), image.getHeight());
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void setValue(int x, int y, Integer value) {
        image.setRGB(x, y, value);
    }

    @Override
    public Integer getValue(int x, int y) {
        return image.getRGB(x, y);
    }
}
