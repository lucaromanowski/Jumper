package com.mygdx.jumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Jumper extends ApplicationAdapter {
	private Music music;
	private Texture playerTexture, platformTexture;
	private JumpPlayer player;
	private Array<Platform> platformArray;
	private OrthographicCamera camera;
	
	private float gravity = -13;
	
	SpriteBatch batch;
	
	
	
	@Override
	public void create () {
		loadData();
		init();
		camera = new OrthographicCamera(480, 800);
		player = new JumpPlayer(playerTexture);
		platformArray = new Array<Platform>();
		
		//Creating platforms
		for (int i = 1; i < 3; i++) {
			Platform p = new Platform(platformTexture);
			p.x = MathUtils.random(0, 480);
			p.y = 200 * i;
			platformArray.add(p);
		}
		
		
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
		batch.setProjectionMatrix(camera.combined);
		for (Platform p : platformArray) {
			p.draw(batch);
		}
		player.draw(batch);
		batch.end();
	}
	
	private void update() {
		handleInput();
		camera.update();
		camera.position.set(player.x + player.width/2,
							player.y + 300,
							0);
		
		player.y += player.jumpVelocity * Gdx.graphics.getDeltaTime();
		
		//Jumping
		if (player.y > 0) {
			player.y += gravity;
		}else {
			player.y = 0;
			player.canJump = true;
			player.jumpVelocity = 0;
		}
		
		//Platform colliding
		for (Platform p : platformArray) {
			if (isPlayerOnPlatform(p)) {
				player.canJump = true;
				player.jumpVelocity = 0;
				player.y = p.y + p.height;
			}
		}
		
	}
	
	private boolean isPlayerOnPlatform(Platform p) {
		return player.jumpVelocity <= 0 && player.overlaps(p) && !(player.y <= p.y);
	}

	public void handleInput() {
		if (Gdx.input.isKeyPressed(Keys.A)) {
			player.x -= 500 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			player.x += 500 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.justTouched()) {
			player.jump();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
