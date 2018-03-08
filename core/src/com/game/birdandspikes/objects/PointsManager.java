package com.game.birdandspikes.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.game.birdandspikes.BirdAndSpikes;

/**
 * Created by franek on 08.03.18.
 */

public class PointsManager {
    private int score = 10;

    private BitmapFont font;
    private GlyphLayout layout;

    public PointsManager(){
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(15f, 15f);
        layout = new GlyphLayout(font, Integer.toString(score));
    }

    public void increasePoints(){
        score++;
    }

    public void draw(SpriteBatch sb){
        font.draw(sb, Integer.toString(score), (BirdAndSpikes.WIDTH - layout.width) / 2, (BirdAndSpikes.HEIGHT + layout.height) / 2);
    }

    public void update(){
        layout = new GlyphLayout(font, Integer.toString(score));
    }

}
