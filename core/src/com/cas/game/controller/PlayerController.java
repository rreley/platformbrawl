package com.cas.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.cas.game.model.Player;

public class PlayerController {
    public static Player player;
    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController() {
        player = new Player(new Vector2(32,30),64,80);
    }

    public static void update(float deltaTime) {
        handleInput();
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }

    private static void handleInput() {
        // To Do: Move to InputController
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if (Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) && player.physicsBody.getLinearVelocity().y == 0) {
            player.physicsBody.applyLinearImpulse(0,20*VELOCITY, position.x, position.y,true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.physicsBody.applyLinearImpulse(-1*VELOCITY, 0, position.x, position.y, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }


    }
}
