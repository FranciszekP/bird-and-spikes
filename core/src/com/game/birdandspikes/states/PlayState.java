package com.game.birdandspikes.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 03.03.18.
 */

public class PlayState extends State {

    private Texture backgroundTexture;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        backgroundTexture = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
