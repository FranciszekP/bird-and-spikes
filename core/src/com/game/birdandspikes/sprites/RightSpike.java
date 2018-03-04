package com.game.birdandspikes.sprites;

import com.game.birdandspikes.objects.Shape;

/**
 * Created by przemyslawwidera on 04.03.2018.
 */

public class RightSpike extends Shape {

    public RightSpike(int x, int y) {
        super(new float[] { x, y, x, y + SpikeManager.SPIKE_HEIGHT, x - (SpikeManager.SPIKE_HEIGHT / 2), y + (SpikeManager.SPIKE_HEIGHT / 2) });
    }
}
