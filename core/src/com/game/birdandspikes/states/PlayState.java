package com.game.birdandspikes.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.BirdAndSpikes;
import com.game.birdandspikes.sprites.Bird;

/**
 * Created by franek on 03.03.18.
 */

public class PlayState extends State {

    private Texture backgroundTexture;
    private Bird bird;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        backgroundTexture = new Texture("bg.png");
        bird = new Bird(0, 300);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        sb.draw(bird.getBirdTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
