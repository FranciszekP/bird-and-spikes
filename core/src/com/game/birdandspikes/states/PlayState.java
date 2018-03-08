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

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);
        backgroundTexture = new Texture("bg.png");
        spikeManager = new SpikeManager();
        spikeManager.generateBottomSpikes();
        spikeManager.generateTopSpikes();
        bird = new Bird(100, 200);
        spikeManager.generateRightSpikes();
        pointsManager = new PointsManager();
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

        if(bird.getPosition().x + bird.getBirdTexture().getWidth() >= BirdAndSpikes.WIDTH){
            bird.reverseFlyingDirection();
            spikeManager.generateLeftSpikes();
            pointsManager.increasePoints();
            pointsManager.update();
        }

        if(bird.getPosition().x <= 0){
            bird.reverseFlyingDirection();
            spikeManager.generateRightSpikes();
            pointsManager.increasePoints();
            pointsManager.update();
        }

        if(spikeManager.checkForCollision(bird.getBounds())){
            gsm.set(new PlayState(gsm));
            pointsManager.increasePoints();
            pointsManager.update();
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(backgroundTexture, 0, 0, BirdAndSpikes.WIDTH, BirdAndSpikes.HEIGHT);

        if (bird.getDirectionStatus() == 1)
           spikeManager.drawRightSpikes(shapeRenderer, sb);
        else
            spikeManager.drawLeftSpikes(shapeRenderer, sb);

        spikeManager.drawHorizontalSpikes(shapeRenderer, sb);
        pointsManager.draw(sb);
        bird.draw(sb);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
