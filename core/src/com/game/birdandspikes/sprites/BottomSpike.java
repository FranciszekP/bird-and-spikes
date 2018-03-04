package com.game.birdandspikes.sprites;

import com.game.birdandspikes.objects.Shape;

/**
 * Created by przemyslawwidera on 04.03.2018.
 */

public class BottomSpike extends Shape {

    public BottomSpike(int x, int y) {
        super(new float[] { x, y, x + SpikeManager.SPIKE_HEIGHT, y, x + (SpikeManager.SPIKE_HEIGHT / 2), y + (SpikeManager.SPIKE_HEIGHT / 2) });
    }
}
