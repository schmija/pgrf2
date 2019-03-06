package view;

import imageData.TestVisibility;
import model.Vertex;
import transforms.Col;

import java.util.function.Function;

public class RasterizerTriangle {

    private TestVisibility tv;
    private Function<Vertex, Col> shader;

    public RasterizerTriangle(TestVisibility tv, Function<Vertex, Col> shader) {
        this.tv = tv;
        this.shader = shader;
    }

    public void rasterize(Vertex a, Vertex b, Vertex c){
        a = a.dehomog();
        b = b.dehomog();
        c = c.dehomog();

        double xA = (a.getPosition().getX() + 1)/2 * (tv.getWidth() - 1);
        double yA = (-a.getPosition().getY() + 1)/2 * (tv.getHeight() - 1);
//        double xB = (b.getPosition().getX() + 1)/2 * (width - 1);
//        double yB = (-a.getPosition().getY() + 1)/2 * (width - 1);
//        double xC = (c.getPosition().getX() + 1)/2 * (width - 1);
//        double yC = (-c.getPosition().getY() + 1)/2 * (width - 1);

        //uspořádat podle y ay <= by <= cy

        for (int y = Math.max(0, (int)yA+1); y <= (int)yB; y++) {
            double t1 = (y-yA)/(yB-yA);

            double x1 = xA*(1-t1) + xB*t2;

            for (int x = x1; x < x2; x+++) {
                double t = (x - x1)/(x2 - x1);
                double z = z1*(1-t)+z2*t;
                Vertex abc;
                tv.setPixel(x,y,z, shader.apply(abc));
            }
        }

    }
}
