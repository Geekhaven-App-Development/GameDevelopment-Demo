package com.betterclever.libgdx.demo;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by betterclever on 1/28/2017.
 */

public class Ball {
	
	ShapeRenderer renderer;
	float radius = 30;
	Vector2 position;
	Vector2 velocity;
	
	public Ball(ShapeRenderer renderer) {
		this.renderer = renderer;
		position = new Vector2(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2);
		velocity = new Vector2(MathUtils.random(-1000,1000), MathUtils.random(-1000,1000));
	}
	
	public void render(float delta){
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.circle(position.x, position.y,radius,256);
		renderer.end();
		
		position.mulAdd(velocity,delta);
		
		if(position.x + radius > Constants.WORLD_WIDTH){
			velocity.x = -velocity.x;
		}
		
		if(position.x - radius < 0){
			velocity.x = -velocity.x;
		}
		
		if(position.y + radius > Constants.WORLD_HEIGHT){
			velocity.y = -velocity.y;
		}
		
		if(position.y - radius < 0){
			velocity.y = -velocity.y;
		}
	}
	
	
}