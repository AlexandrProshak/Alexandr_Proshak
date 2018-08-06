package ru.job4j.bomberv2.models.factories;

import ru.job4j.bomberv2.controllers.GameController;
import ru.job4j.bomberv2.models.entities.Monster;
import ru.job4j.bomberv2.models.playground.Field;

/**
 * The class MonsterThreadFactory describes the thread of the monster.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class MonsterThreadFactory {

    /**
     * The static factory method of generating monster thread.
     * @param controller of the game.
     * @param field of thr game.
     * @return a thread for the monster.
     */
    public static Thread getMonsterThread(final GameController controller, final Field field) {
        Thread monsterThread = new Thread(Monster.getMonster(controller, field));
        monsterThread.setName("Monster");
        monsterThread.setDaemon(true);
        return monsterThread;
    }
}
