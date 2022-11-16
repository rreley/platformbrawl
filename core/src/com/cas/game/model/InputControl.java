package com.cas.game.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.cas.game.controller.LevelController;

public class InputControl {
    public String action;
    public Vector2 position;
    private TextureRegion textureRegion;
    private float w;
    private float h;

    // To Do: Refer to InputController

    public InputControl(Vector2 position, TextureRegion textureRegion, String action) {
        this.position = position;
        this.textureRegion = textureRegion;
        this.action = action;
        w = textureRegion.getRegionWidth();
        h = textureRegion.getRegionHeight();

    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(textureRegion, position.x, position.y, w * LevelController.UNIT_SCALE, h * LevelController.UNIT_SCALE);
    }
}
