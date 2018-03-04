package com.game.birdandspikes.sprites;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.birdandspikes.BirdAndSpikes;

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
                rightSpikes.add(new RightSpike(BirdAndSpikes.WIDTH, (i * 2) * SPIKE_HEIGHT + MARGIN));
                rightSpikes.add(new RightSpike(BirdAndSpikes.WIDTH, (i * 2 + 1) * SPIKE_HEIGHT + MARGIN));
            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        for(TopSpike spike : topSpikes) {
            spike.drawDebug(shapeRenderer);
        }

        for(BottomSpike spike : bottomSpikes) {
            spike.drawDebug(shapeRenderer);
        }

        for(LeftSpike spike : leftSpikes) {
            spike.drawDebug(shapeRenderer);
        }

        for(RightSpike spike : rightSpikes) {
            spike.drawDebug(shapeRenderer);
        }

    }
}
