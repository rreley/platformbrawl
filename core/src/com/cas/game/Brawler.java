package com.cas.game;

import com.badlogic.gdx.Game;
import com.cas.game.view.GameScreen;

public class Brawler extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
