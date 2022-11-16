package com.cas.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {

    public TextureRegion[] spriteFrames;
    public Texture spriteSheet;

    public SpriteSheet(String pathToFile, int w, int h) {

        int spriteCount = 0;
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));

        // chops up texture into a 2d array of texture regions
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet,w,h);

        // counts number of texture regions
        for(int i = 0; i < spriteSheetFrames.length; i++) {
            for (int j = 0; j < spriteSheetFrames[i].length; j++) {
                spriteCount++;
            }
        }

        spriteFrames = new TextureRegion[spriteCount];
        spriteCount = 0;

        // maps texture regions in 2d array to a 1d array of texture regions
        for(int i =0; i < spriteSheetFrames.length; i++) {
            for (int j = 0; j < spriteSheetFrames[i].length; j++) {
                spriteFrames[spriteCount++] = spriteSheetFrames[i][j];
            }
        }
    }

    public Animation<TextureRegion> getAnimation(int startFrame, int endFrame, float fps) {
        TextureRegion[] animationFrames = new TextureRegion[endFrame - startFrame + 1];
        for (int i = startFrame; i <= endFrame; i++) {
            animationFrames[i] = spriteFrames[i];
        }
        return new Animation<TextureRegion>(1/fps, animationFrames);
    }

    public Animation<TextureRegion> flipAnimation(Animation<TextureRegion> originalAnimation, boolean flipx, boolean flipy) {
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for (int i = 0; i <= frameCount - 1; i++) {
            flippedFrames[i] = new TextureRegion(originalAnimation.getKeyFrames()[i]);
            flippedFrames[i].flip(flipx, flipy);
        }

        return new Animation<TextureRegion>(originalAnimation.getFrameDuration(), flippedFrames);
    }
}
