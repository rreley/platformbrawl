package com.cas.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.cas.game.controller.CameraController;
import com.cas.game.controller.LevelController;
import com.cas.game.controller.PlayerController;

public class GameScreen implements Screen {

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // puts blue color on background
        Gdx.gl.glClearColor(0.75f, 0.89f, 0.93f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // update everything
        CameraController.update();
        LevelController.update(delta);
        PlayerController.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
