package com.game.birdandspikes.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by przemyslawwidera on 03.03.2018.
 */

public class Shape {
    protected final static float SIN_22_5 = 0.383f;
    protected final static float COS_22_5 = 0.924f;
    protected final static float SQRT_2 = 1.414f;

    protected float[] vertices;
    protected Polygon shape;
    protected Texture texture;
    protected int x, y;

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

    public float[] turnIntoVertices(Circle circle) { // https://drive.google.com/open?id=1EgcGb-gkcBGolVkuFjgNb2D-mVsArPTn
        float radius = circle.radius;
        float x = radius * COS_22_5;
        float h = radius * SIN_22_5;
        float a = (radius * SQRT_2) / 2;
        return new float[] { circle.x - radius, circle.y, // 1
                circle.x - x, circle.y + h, // 2
                circle.x - a, circle.y + a, // 3
                circle.x - h, circle.y + x, // 4
                circle.x, circle.y + radius, // 5
                circle.x + h, circle.y + x, // 6
                circle.x + a, circle.y + a, // 7
                circle.x + x, circle.y + h, // 8
                circle.x + radius, circle.y, // 9
                circle.x + x, circle.y - h, // 10
                circle.x + a, circle.y - a, // 11
                circle.x + h, circle.y - x, // 12
                circle.x, circle.y - radius, // 13
                circle.x - h, circle.y - x, // 14
                circle.x - a, circle.y - a, // 15
                circle.x - x, circle.y - h };// 16
    }
}
