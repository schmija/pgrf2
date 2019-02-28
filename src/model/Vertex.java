package model;

import transforms.Point3D;

public class Vertex {

    private Point3D positon;

    public Vertex(Point3D positon) {
        this.positon = positon;
    }

    public Point3D getPosition(){

        return positon;
    }

    public Vertex mul(double s){

        return new Vertex(positon.mul(s));
    }

    public Vertex add(Point3D p){
        return new Vertex(positon.add(p));
    }
}
