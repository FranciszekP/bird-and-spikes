package com.game.birdandspikes.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 03.03.18.
 */

public class MenuState extends State {
    private Texture buttonTexture;
    private Texture backgroundTexture;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        buttonTexture = new Texture("btn.png");
        backgroundTexture = new Texture("bg.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) ;
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        sb.draw(buttonTexture, (BirdAndSpikes.WIDTH / 2) - (buttonTexture.getWidth() / 2), (BirdAndSpikes.HEIGHT / 2) - (buttonTexture.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {

    }
}