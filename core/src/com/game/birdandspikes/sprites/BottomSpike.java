package com.game.birdandspikes.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.objects.Shape;

/**
 * Created by przemyslawwidera on 04.03.2018.
 */

public class BottomSpike extends Shape {

    public BottomSpike(int x, int y) {
        super(new float[] { x, y, x + SpikeManager.SPIKE_HEIGHT, y, x + (SpikeManager.SPIKE_HEIGHT / 2), y + (SpikeManager.SPIKE_HEIGHT / 2) });
        texture = new Texture(Gdx.files.internal("botspikes.png"));
        this.x = x;
        this.y = y;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y - SpikeManager.MARGIN);
    }
}
