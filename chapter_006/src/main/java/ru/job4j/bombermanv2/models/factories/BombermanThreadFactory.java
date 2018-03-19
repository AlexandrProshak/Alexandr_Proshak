package ru.job4j.bombermanv2.models.factories;

import ru.job4j.bombermanv2.controllers.GameController;
import ru.job4j.bombermanv2.models.entities.Bomberman;
import ru.job4j.bombermanv2.models.playground.Field;

/**
 * The class BombermanThreadFactory describes the thread of the Bomberman.
 */
public class BombermanThreadFactory {

    /**
     * The static factory method of generating Bomberman thread.
     * @param controller of the game.
     * @param field of thr game.
     * @return a thread for the Bomberman.
     */
    public static Thread getBombermanThread(final GameController controller, final Field field) {
        Bomberman bomber = new Bomberman(controller, field);
        Thread bomberThread = new Thread(bomber);
        bomberThread.setName("Bomber");
        bomberThread.setDaemon(true);
        return bomberThread;
    }

}
