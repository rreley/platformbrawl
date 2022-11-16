package com.cas.game.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.cas.game.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body physicsBody;
    public Vector2 position;
    public SpriteSheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;
    private float stateTime;
    protected HashMap<String, Animation<TextureRegion>> animations;

    public Sprite(String pathToFile, Vector2 position, int width, int height) {
        this.position = position;
        this.width = width* LevelController.UNIT_SCALE;
        this.height = height*LevelController.UNIT_SCALE;
        spriteSheet = new SpriteSheet(pathToFile,width,height);
        animations = new HashMap<String, Animation<TextureRegion>>();
        stateTime = 0f;
        // state time starts at zero and increments for the duration that the sprite is on the screen
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime) {stateTime += deltaTime;}
    // used to update the state time, which is used in all other update functions
}
