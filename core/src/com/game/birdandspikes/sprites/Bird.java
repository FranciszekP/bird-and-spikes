package com.game.birdandspikes.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 03.03.18.
 */

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private static final int JUMP_FORCE = 250;

    private Texture birdTexture;

    private Vector3 position;
    private Vector3 velocity;

    int directionStatus = 1;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        birdTexture = new Texture("bird.png");
    }

    public void update(float dt) {

        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);

        velocity.scl(dt);
        position.add(directionStatus * MOVEMENT * dt, velocity.y, 0);

        if (position.y < 0)
            position.y = 0;

        velocity.scl(1/dt);

        if (position.x + birdTexture.getWidth() >= BirdAndSpikes.WIDTH || position.x <= 0)
            directionStatus *= -1;

    }

    public void jump(){
        velocity.y = JUMP_FORCE;
    }

    public Texture getBirdTexture() {
        return birdTexture;
    }

    public Vector3 getPosition() {
        return position;
    }
}
