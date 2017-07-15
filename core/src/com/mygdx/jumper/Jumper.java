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
		loadData();
		init();
		
		
	}

	private void init() {
		batch = new SpriteBatch();
		music.play();
		
	}

	private void loadData() {
		playerTexture = new Texture("mario2.png");
		platformTexture = new Texture("platform.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		player.draw(batch);
		batch.end();
	}
	
	private void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
