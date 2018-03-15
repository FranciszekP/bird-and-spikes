package com.game.birdandspikes.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 03.03.18.
 */

public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gameStateManager;

    protected State (GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected void setOrthographicCameraWithDefaultScreenHeightAndWidth(){
        camera.setToOrtho(false, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}