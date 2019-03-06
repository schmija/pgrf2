package imageData;

public class DepthBuffer implements Image<Float>{

    private int width;
    private int height;

    private float depthBuffer[][];

    public DepthBuffer(int width, int height) {
        this.width = width;
        this.height = height;
        depthBuffer = new float[width][height];
    }

    public void clear(){

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                depthBuffer[i][j] = 1.0f;
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setValue(int x, int y, Float value) {
        depthBuffer[x][y] = value;
    }

    @Override
    public Float getValue(int x, int y) {
        return depthBuffer[x][y];
    }

}
