package com.game.birdandspikes.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.game.birdandspikes.BirdAndSpikes;
import com.game.birdandspikes.objects.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by przemyslawwidera on 04.03.2018.
 */

public class SpikeManager {
    public static final int SPIKE_HEIGHT = 40;
    public static final int MARGIN = 40;
    public static final int VERTICAL_SPIKES_COUNT = 16;
    public static final int HORIZONTAL_SPIKES_COUNT = 12;

    private List<LeftSpike> leftSpikes;
    private List<RightSpike> rightSpikes;
    private List<TopSpike> topSpikes;
    private List<BottomSpike> bottomSpikes;
    private int emptyLeft, emptyRight;
    private Random random;

    public SpikeManager() {
        leftSpikes = new ArrayList<LeftSpike>();
        rightSpikes = new ArrayList<RightSpike>();
        topSpikes = new ArrayList<TopSpike>();
        generateTopSpikes();
        bottomSpikes = new ArrayList<BottomSpike>();
        generateBottomSpikes();

        random = new Random();
    }

    public void generateTopSpikes() {
        for(int i = 0; i < VERTICAL_SPIKES_COUNT; i++) {
            topSpikes.add(new TopSpike(i * SPIKE_HEIGHT, VERTICAL_SPIKES_COUNT * SPIKE_HEIGHT + (SPIKE_HEIGHT / 2)));
        }
    }

    public void generateBottomSpikes() {
        for(int i = 0; i < VERTICAL_SPIKES_COUNT; i++) {
            bottomSpikes.add(new BottomSpike(i * SPIKE_HEIGHT, MARGIN));
        }
    }

    public void generateLeftSpikes() {
        emptyLeft = random.nextInt(VERTICAL_SPIKES_COUNT / 2);
        leftSpikes.clear();
        for(int i = 0; i < VERTICAL_SPIKES_COUNT / 2; i++) {
            if(i != emptyLeft) {
                leftSpikes.add(new LeftSpike(0, (i * 2) * SPIKE_HEIGHT + MARGIN));
                leftSpikes.add(new LeftSpike(0, (i * 2 + 1) * SPIKE_HEIGHT + MARGIN));
            }
        }
    }

    public void generateRightSpikes() {
        emptyRight = random.nextInt(VERTICAL_SPIKES_COUNT / 2);
        rightSpikes.clear();
        for(int i = 0; i < (VERTICAL_SPIKES_COUNT / 2); i++) {
            if(i != emptyRight) {
                rightSpikes.add(new RightSpike(BirdAndSpikes.WIDTH - (SPIKE_HEIGHT / 2), (i * 2) * SPIKE_HEIGHT + MARGIN));
                rightSpikes.add(new RightSpike(BirdAndSpikes.WIDTH - (SPIKE_HEIGHT / 2), (i * 2 + 1) * SPIKE_HEIGHT + MARGIN));
            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        for(TopSpike spike : topSpikes) {
            //spike.drawDebug(shapeRenderer);
            spike.draw(spriteBatch);
        }

        for(BottomSpike spike : bottomSpikes) {
            //spike.drawDebug(shapeRenderer);
            spike.draw(spriteBatch);
        }

        for(LeftSpike spike : leftSpikes) {
            //spike.drawDebug(shapeRenderer);
            spike.draw(spriteBatch);
        }

        for(RightSpike spike : rightSpikes) {
            //spike.drawDebug(shapeRenderer);
            spike.draw(spriteBatch);
        }

    }

    public void drawLeftSpikes(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch){
        for(LeftSpike spike : leftSpikes) {
            spike.draw(spriteBatch);
        }
    }

    public void drawRightSpikes(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch){
        for(RightSpike spike : rightSpikes) {
            spike.draw(spriteBatch);
        }
    }

    public void drawHorizontalSpikes(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch){
        for(TopSpike spike : topSpikes) {
            spike.draw(spriteBatch);
        }

        for(BottomSpike spike : bottomSpikes) {
            spike.draw(spriteBatch);
        }
    }


    public boolean checkForCollision(float[] vertices) {
        for(TopSpike spike : topSpikes) {
            if(spike.collides(vertices)) return true;
        }

        for(BottomSpike spike : bottomSpikes) {
            if(spike.collides(vertices)) return true;
        }

        for(LeftSpike spike : leftSpikes) {
            if(spike.collides(vertices)) return true;
        }

        for(RightSpike spike : rightSpikes) {
            if(spike.collides(vertices)) return true;
        }
        return false;
    }

    public boolean checkForCollision(Rectangle rectangle) {
        if(checkForCollision(Shape.turnIntoVertices(rectangle))) return true;
        else return false;
    }
}
