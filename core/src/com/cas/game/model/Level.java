package com.cas.game.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap stage;
    public Level(String stagePath) {
        stage = new TmxMapLoader().load(stagePath);
    }

    public MapLayer getMapLayer(String layerName) {
        return stage.getLayers().get(layerName);
    }

    public MapObjects getMapObjects(MapLayer mapLayer) {
        return mapLayer.getObjects();
    }
}
