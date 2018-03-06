package com.game.birdandspikes.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.objects.Shape;

/**
 * Created by przemyslawwidera on 04.03.2018.
 */

public class TopSpike extends Shape {

    public TopSpike(int x, int y) {
        super(new float[] { x, y + (SpikeManager.SPIKE_HEIGHT / 2), x + SpikeManager.SPIKE_HEIGHT, y + (SpikeManager.SPIKE_HEIGHT / 2), x + (SpikeManager.SPIKE_HEIGHT / 2), y });
        texture = new Texture(Gdx.files.internal("topspikes.png"));
        this.x = x;
        this.y = y;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }
}
