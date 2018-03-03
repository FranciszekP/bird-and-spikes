package com.game.birdandspikes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.birdandspikes.BirdAndSpikes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = BirdAndSpikes.WIDTH;
		config.height = BirdAndSpikes.HEIGHT;
		config.title = BirdAndSpikes.TITLE;
		new LwjglApplication(new BirdAndSpikes(), config);
	}
}
