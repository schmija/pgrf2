package ImageData.Model;

import sun.security.provider.certpath.Vertex;

import java.util.List;

public abstract class Solid {
    protected List<Vertex> vertexBuffer;
    protected List<Integer> indexBuffer;
    protected List<Part> partBuffer;
}
