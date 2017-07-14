package com.mygdx.jumper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Platform extends Rectangle {
	
	private Texture texture;
	
	//Conctructor
	public Platform(Texture texture) {
		this.texture = texture;
		this.height = texture.getHeight();
		this.width = texture.getWidth();
	}
	
	//Drawing
	public void draw(SpriteBatch batch) {
		batch.draw(texture, x, y);
	}
}
