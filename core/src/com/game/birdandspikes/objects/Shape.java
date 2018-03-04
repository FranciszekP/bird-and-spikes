package com.game.birdandspikes.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by przemyslawwidera on 03.03.2018.
 */

public class Shape {
    private float[] vertices;
    private Polygon shape;

    public Shape(float[] vertices) {
        this.vertices = vertices;
        shape = new Polygon(vertices);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        for(int i = 0; i < (vertices.length - 2); i += 2) {
            shapeRenderer.line(vertices[i], vertices[i + 1], vertices[i + 2], vertices[i + 3]);
        }
        shapeRenderer.line(vertices[0], vertices[1], vertices[vertices.length - 2], vertices[vertices.length - 1]);
    }

    public boolean collides(float[] vertices) {
        for(int i = 0; i < vertices.length; i += 2) {
            if(shape.contains(vertices[i], vertices[i + 1])) return true;
        }
        return false;
    }

    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }
}
