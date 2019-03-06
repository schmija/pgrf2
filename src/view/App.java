package view;

import imageData.TestVisibility;
import model.Arrow;
import model.Solid;
import model.Vertex;
import transforms.Col;

public class App {
    public void start(){
        Solid s = new Arrow();
        TestVisibility tv = new TestVisibility(img);

        /*Shader shader = new Shader() {
            @Override
            public Col shade(Vertex vertex) {

                return new Col(0xffffff);
            }
        };
        RasterizerTriangle rt = new RasterizerTriangle(tv, shader);*/

        RasterizerTriangle rt = new RasterizerTriangle(tv, (vertex) -> new Col(0xffffff));
        Renderer renderer = new Renderer(rt);

    }
}
