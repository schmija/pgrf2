package view;

import model.Part;
import model.Solid;
import model.Vertex;

public class Renderer {

    RasterizerTriangle rt;

    public Renderer(RasterizerTriangle rt) {
        this.rt = rt;
    }

    public void render(Solid solid){
        for (Part part : solid.getPartBuffer()) {
            switch (part.getTopology()){
                case Points:
                    for (int i = 0; i < part.getCount(); i++) {
                        int index = part.getStart() + i;
                        int indexVB = solid.getIndexBuffer().get(index);
                        Vertex a = solid.getVertexBuffer().get(indexVB);
                        renderPoint(a);
                    }
                    break;
                case Lines:

                    break;
                case Triangles:
                    for (int i = 0; i < part.getCount(); i++) {
                        Vertex a = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3*i + part.getStart()));
                        Vertex b = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3*i + part.getStart()) + 1);
                        Vertex c = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3*i + part.getStart()) + 2);

                        renderTriangle(a, b, c);
                    }
                    break;
            }
        }
    }

    public void renderTriangle(Vertex a, Vertex b, Vertex c) {
        //transformace MVP
        //ořezání

//        if ((a.x>w && b.x>w && c.x>w) || (a.y<w && b.y<w && c.y<w) || (a.z>0 && b.z>0 && c.z>0) ){
//
//        }
//        ořez pro z=0

        if (a.getPosition().getZ() < b.getPosition().getZ()){
            Vertex tmp;
            tmp = a;
            a = b;
            b = tmp;
        }
        if( b.getPosition().getZ() < c.getPosition().getZ()){
            Vertex tmp;
            tmp = b;
            b = c;
            c = tmp;
        }
        if (a.getPosition().getZ() < b.getPosition().getZ()){
            Vertex tmp;
            tmp = a;
            a = b;
            b = tmp;
        }

        if (a.getPosition().getZ() < 0){
            return;
        }

        if (b.getPosition().getZ() < 0){
//            double t;
//            Vertex ab = b.mul(1-t).add(a.mul(t));
//            Vertex ac = c.mul(1-t).add(a.mul(t));

//            rt.rasterize(a, ab, ac);
            return;
        }
        if (c.getPosition().getZ() < 0){

//            rt.rasterize(a, b, bc);
//            rt.rasterize(a, ac, bc);
//            return;
        }

        rt.rasterize(a,b,c);

    }

    public void renderPoint(Vertex a){

    }
}
