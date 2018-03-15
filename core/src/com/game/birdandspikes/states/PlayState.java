package com.game.birdandspikes.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.birdandspikes.BirdAndSpikes;
import com.game.birdandspikes.objects.PointsManager;
import com.game.birdandspikes.sprites.Bird;
import com.game.birdandspikes.sprites.SpikeManager;

/**
 * Created by franek on 03.03.18.
 */

public class PlayState extends State {

    private Texture backgroundTexture;
    private SpikeManager spikeManager;
    private ShapeRenderer shapeRenderer;
    private Bird bird;
    private PointsManager pointsManager;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        setOrthographicCameraWithDefaultScreenHeightAndWidth();

        setBackgroundTexture();

        spikeManager = new SpikeManager();
        generateSpikes();

        bird = new Bird(100, 200);

        pointsManager = new PointsManager();
    }

    private void setBackgroundTexture(){
        backgroundTexture = new Texture("bg.png");
    }

    private void generateSpikes(){
        spikeManager.generateBottomSpikes();
        spikeManager.generateTopSpikes();
        spikeManager.generateRightSpikes();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

        if(bird.isTouchingRightSideOfTheScreen()){
            bird.reverseFlyingDirection();
            spikeManager.generateLeftSpikes();
            pointsManager.increasePoints();
            pointsManager.update();
        }

        if(bird.isTouchingLeftSideOfTheScreen()){
            bird.reverseFlyingDirection();
            spikeManager.generateRightSpikes();
            pointsManager.increasePoints();
            pointsManager.update();
        }

        if(isBirdCollidingWithSpikes()){
            setNewPlayState();
            pointsManager.increasePoints();
            pointsManager.update();
        }

    }

    private boolean isBirdCollidingWithSpikes(){
        return spikeManager.checkForCollision(bird.getBounds());
    }

    private void setNewPlayState(){
        gameStateManager.set(new PlayState(gameStateManager));
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        drawBackgroundTexture(spriteBatch);

        if (bird.getDirectionStatus() == 1)
           spikeManager.drawRightSpikes(shapeRenderer, spriteBatch);
        else
            spikeManager.drawLeftSpikes(shapeRenderer, spriteBatch);

        spikeManager.drawHorizontalSpikes(shapeRenderer, spriteBatch);
        pointsManager.draw(spriteBatch);
        bird.draw(spriteBatch);

        spriteBatch.end();

    }

    private void drawBackgroundTexture(SpriteBatch spriteBatch){
        spriteBatch.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
    }
}
