package com.game.birdandspikes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.birdandspikes.states.GameStateManager;
import com.game.birdandspikes.states.MenuState;

public class BirdAndSpikes extends ApplicationAdapter {
<<<<<<< HEAD
	SpriteBatch batch;
	Texture img;

=======
	private GameStateManager gsm;
	private SpriteBatch batch;
	
>>>>>>> bef859dbcdc6b788a43daaaa338e9dc498a47e6d
	@Override
	public void create() {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
<<<<<<< HEAD
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
=======
	public void render () {
>>>>>>> bef859dbcdc6b788a43daaaa338e9dc498a47e6d
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
