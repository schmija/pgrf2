package ImageData.Model;

import sun.security.provider.certpath.Vertex;

public class Arrow extends Solid {
    private Solid solid;

    public Arrow() {
        vertexBuffer.add(new Vertex())

        indexBuffer.add(0); indexBuffer.add(1);
        indexBuffer.add(1); indexBuffer.add(2); indexBuffer.add(3);
        partBuffer.add(new Part(Topology.Lines,0,1));
        partBuffer.add(new Part(Topology.Triangles, 2, 1));
        solid = new Arrow();
    }
}
