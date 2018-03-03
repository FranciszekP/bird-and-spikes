package com.game.birdandspikes.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 03.03.18.
 */

public class MenuState extends State {
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, BirdAndSpikes.WIDTH/2, BirdAndSpikes.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
    }

    @Override
    public void dispose() {
    }
}