package imageData;

public interface Image<T> {
    int getWidth();

    int getHeight();

    void setValue(int x, int y, T value);

    T getValue(int x, int y);
}
