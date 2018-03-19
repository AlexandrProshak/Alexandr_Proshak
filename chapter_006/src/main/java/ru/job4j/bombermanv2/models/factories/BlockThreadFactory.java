package ru.job4j.bombermanv2.models.factories;

import ru.job4j.bombermanv2.controllers.GameController;
import ru.job4j.bombermanv2.models.playground.Block;
import ru.job4j.bombermanv2.models.playground.Field;

/**
 * The class BlockThreadFactory describes the thread of the block.
 */
public class BlockThreadFactory {

    /**
     * The static factory method of generating blocks thread.
     * @param controller of the game.
     * @param field of thr game.
     * @return a thread for the block.
     */
    public static Thread getBlockThread(final GameController controller, final Field field) {
        Thread blockThread = new Thread(Block.getBlock(controller, field));
        blockThread.setName("Block");
        blockThread.setDaemon(true);
        return blockThread;
    }

}
