package com.mygdx.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class JumpPlayer extends Rectangle  {
	
	private Sound jumpSound;
	private Texture texture;
	public boolean canJump = true;
	
	public float jumpVelocity;
	
	//Constructor
	public JumpPlayer(Texture texture) {
		this.texture = texture;
		this.width = texture.getWidth();
		this.height = texture.getHeight();
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("Jump33.wav"));
	}
	
	//This method is responsible for drawing our object on the screen
	public void draw(SpriteBatch batch) {
		batch.draw(texture, x, y);
	}
	
	//This method will make Mario jump like Criss Cross!!
	public void jump() {
		if(canJump && jumpVelocity >= -100) {
			jumpVelocity += 800;
			canJump = false;
			jumpSound.play();
		}
	}

}
