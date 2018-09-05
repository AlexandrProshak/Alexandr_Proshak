package ru.job4j.bomberv2.controllers;

/**
 * The class GameController.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class GameController {

    /**
     * The volatile boolean flag indicates game's activity.
     */
    private volatile boolean game;

    /**
     * The method allows game's start.
     */
    public void startGame() {
        this.game = true;
        System.out.println("  Start game");
    }

    /**
     * The method set stop game.
     */
    public void stopGame() {
        this.game = false;
        System.out.println("  Game over");
    }

    /**
     * The method shows game's state.
     * @return true in case while the Bomberman is alive.
     */
    public boolean isGame() {
        return game;
    }

}
