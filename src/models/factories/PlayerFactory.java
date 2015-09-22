package models.factories;

import gfx.Assets;
import models.Player;

import java.awt.image.BufferedImage;

public class PlayerFactory {
    private static final int METEOR_WIDTH  = 80;
    private static final int METEOR_HEIGHT = 110;

    private static final int           PLAYER_X        = 370;
    private static final int           PLAYER_Y        = 100;
    private static final BufferedImage PLAYER_IMAGE    = Assets.meteor.crop(0, 0, METEOR_WIDTH, METEOR_HEIGHT);
    private static final int           PLAYER_VELOCITY = 10;
    private static final int           PLAYER_HEALTH   = 100;

    public static Player generatePlayer() {
        Player createdPlayer = Player.createInstance(PLAYER_X, PLAYER_Y, PLAYER_IMAGE,
                PLAYER_VELOCITY,
                PLAYER_HEALTH);

        return createdPlayer;
    }
}
