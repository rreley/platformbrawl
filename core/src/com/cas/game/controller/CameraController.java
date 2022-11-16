package com.cas.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(32f, 32f*h/w); // multiply height by aspect ratio (h/w)
        camera.position.set(36, 32, 0);
    }

    public static void update() {camera.update();}

    public static void resize(int width, int height) {
        camera.viewportWidth = 32f;
        camera.viewportHeight = 32f*height/width;
        camera.update();
    }
}
