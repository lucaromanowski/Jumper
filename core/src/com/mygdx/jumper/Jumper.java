package com.mygdx.jumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Jumper extends ApplicationAdapter {
	private Music music;
	private Texture playerTexture, platformTexture;
	private JumpPlayer player;
	private Array<Platform> platformArray;
	private OrthographicCamera camera;
	
	private float gravity = -20;
	
	SpriteBatch batch;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
