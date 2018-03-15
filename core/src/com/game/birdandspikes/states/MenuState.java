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

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        setOrthographicCameraWithDefaultScreenHeightAndWidth();
        setButtonAndBackgroundTextures();
    }

    private void setButtonAndBackgroundTextures() {
        buttonTexture = new Texture("btn.png");
        backgroundTexture = new Texture("bg.png");
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
            setPlayState();
    }

    private void setPlayState(){
        gameStateManager.set(new PlayState(gameStateManager));
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        drawBackgroundTexture(spriteBatch);
        drawButtonTexture(spriteBatch);

        spriteBatch.end();
    }

    private void drawBackgroundTexture(SpriteBatch spriteBatch){
        spriteBatch.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
    }

    private void drawButtonTexture(SpriteBatch spriteBatch){
        spriteBatch.draw(buttonTexture, (BirdAndSpikes.WIDTH / 2) - (buttonTexture.getWidth() / 2), (BirdAndSpikes.HEIGHT / 2) - (buttonTexture.getHeight() / 2));
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        buttonTexture.dispose();
    }
}