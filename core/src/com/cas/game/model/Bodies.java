package com.cas.game.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.cas.game.controller.LevelController;

public class Bodies {

    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString();

        if (bodyType.equalsIgnoreCase("solid")) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject)mapObject;
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(rectangleMapObject.getRectangle().x * LevelController.UNIT_SCALE, rectangleMapObject.getRectangle().y * LevelController.UNIT_SCALE);

            Body physicBody = LevelController.gameWorld.createBody(bodyDef);
            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE / 2f, new Vector2(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE / 2f), 0f);

            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = rectangleShape;

            physicBody.createFixture(fixtureDef);
            rectangleShape.dispose();
        } else if (bodyType.equalsIgnoreCase("slope")) {
            PolygonMapObject polygonMapObject = (PolygonMapObject)mapObject;
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(polygonMapObject.getPolygon().getX() * LevelController.UNIT_SCALE, polygonMapObject.getPolygon().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDef);
            PolygonShape polygonShape = new PolygonShape();

            float[] transformedVertices = new float[polygonMapObject.getPolygon().getVertices().length];

            for (int i = 0; i < transformedVertices.length; i++) {
                transformedVertices[i] = polygonMapObject.getPolygon().getVertices()[i];
            }

            polygonShape.set(transformedVertices);

            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = polygonShape;

            physicsBody.createFixture(fixtureDef);
            polygonShape.dispose();
        }
    }
}
