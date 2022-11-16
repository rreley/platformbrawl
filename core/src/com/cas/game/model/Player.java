package com.cas.game.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.cas.game.controller.LevelController;

public class Player extends Sprite {


    public Player(Vector2 position, int width, int height) {
        // constructor of parent
        super("img/shad.png", position, width, height);

        // creates dynamic body in the location of the player
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        physicsBody = LevelController.gameWorld.createBody(bodyDef);
        physicsBody.setUserData(this);

        // Attaches correctly sized rectangular fixture to body
        PolygonShape rectShape = new PolygonShape();
        rectShape.setAsBox(this.width/2f,this.height/2f, new Vector2(this.width/2f,this.height/2f), 0f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectShape;
        physicsBody.createFixture(fixtureDef);

        rectShape.dispose();

        // create a right-facing walk animation and put it in animations
        animations.put("walkRight", spriteSheet.getAnimation(0, 7, 12));
        // create a left-facing walk animation by flipping the first animation
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        currentAnimation = "walkRight";

    }

    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }

    public void update(float deltaTime) {
        if (this.physicsBody.getLinearVelocity().x > 0) {
            currentAnimation = "walkRight";
        } else if (this.physicsBody.getLinearVelocity().x < 0) {
            currentAnimation = "walkLeft";
        }
        super.update(deltaTime);
    }
}
