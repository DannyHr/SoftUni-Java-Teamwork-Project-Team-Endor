package state;

import game.Engine;
import gfx.Assets;
import models.MenuButton;
import models.backgrounds.Background;
import models.factories.GameEndScreenFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class CreditsState extends State{
    private static final BufferedImage BACK_TO_MENU_BUTTON_HOVERED_IMAGE  = Assets.endGameBackToMenu;
    private static final BufferedImage BACK_TO_MENU_BUTTON_INACTIVE_IMAGE = Assets.endGameInactiveBackToMenu;

    private int velocity = 5;

    private Background background;

    List<MenuButton> buttons;
    private int hoveredButtonIndex;

    public CreditsState() {
        this.init();
    }

    protected void setBackground(Background background) {
        this.background = background;
    }

    public int getHoveredButtonIndex() {
        return this.hoveredButtonIndex;
    }

    public void setHoveredButtonIndex(int hoveredButtonIndex) {
        this.hoveredButtonIndex = hoveredButtonIndex;
    }

    public int numberOfButtons() {
        return this.buttons.size();
    }

    private int getVelocity() {
        return velocity;
    }

    public void init() {
        this.setBackground(new Background(Assets.creditsBackground));

        this.buttons = new ArrayList<>();

        int buttonX = Engine.WINDOW_WIDTH / 2 - BACK_TO_MENU_BUTTON_HOVERED_IMAGE.getWidth() / 2;
        int buttonY = 450;
        MenuButton backToMenu = new MenuButton(buttonX,
                buttonY,
                BACK_TO_MENU_BUTTON_HOVERED_IMAGE,
                BACK_TO_MENU_BUTTON_INACTIVE_IMAGE);

        this.buttons.add(backToMenu);

        this.hoveredButtonIndex = 0;
    }

    @Override
    public void tick() {
        for (int i = 0; i < this.buttons.size(); i++) {
            if (i == hoveredButtonIndex) {
                this.buttons.get(i).setIsHovered(true);
            } else {
                this.buttons.get(i).setIsHovered(false);
            }
        }

        for (MenuButton button : this.buttons) {
            button.tick(this.getVelocity());
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.background.render(graphics);

        for (MenuButton button : this.buttons) {
            button.render(graphics);
        }
    }
}