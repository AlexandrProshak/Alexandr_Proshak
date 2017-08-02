package ru.job4j.collections;

import java.util.Collection;
import java.util.Iterator;

/**
 * Class CollectionsPerformance.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class CollectionsPerformance {

    /**
     * A method add calculates time adding
     * huge amount of String lines into a Collection.
     * @param collection for adding.
     * @param amount of String lines
     * @return an operation time ms.
     */
    public long add(Collection<String> collection, int amount) {
        String line = "abracadabra";
        long result = System.currentTimeMillis();
        for (int i = 0; i <= amount; i++) {
            collection.add(line + i);
        }
        result = System.currentTimeMillis() - result;
        return result;
    }

    /**
     * A method delete calculates time deleting
     * huge amount of String lines into a Collection.
     * @param collection for adding.
     * @param amount of String lines
     * @return an operation time ms.
     */
    public long delete(Collection<String> collection, int amount) {
        long result = System.currentTimeMillis();
        Iterator<String> iterator = collection.iterator();
        for (int i = 0; i <= amount; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        result = System.currentTimeMillis() - result;
        return result;
    }
}
