package ru.job4j.task1;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * The non blocking cache.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <E> generic parameter.
 */
@ThreadSafe
public class NonBlockingCache<E extends Model> {

    /**
     * The cash storage.
     */
    private final ConcurrentHashMap<Long, Model> storage = new ConcurrentHashMap<>();

    /**
     * The method returns the cache size.
     * @return size;
     */
    public int size() {
        return storage.size();
    }

    /**
     * The method adds new item to the cache.
     * @param model to be added.
     */
    public void add(Model model) {
        this.storage.put(model.getId(), model);
    }

    /**
     * The method updates the present item.
     * In case of failure throws OptimisticException().
     * @param newModel to be updated.
    * @throws OptimisticException throws in case of failure.
     */
    public void update(Model newModel) throws OptimisticException {
        this.storage.computeIfPresent(newModel.getId(), (id, oldModel) -> {
            if (newModel.getVersion().get() == (oldModel.getVersion().get())) {
                oldModel.setName(newModel.getName());
            } else {
                try {
                    throw new OptimisticException("wrong version");
                } catch (OptimisticException e) {
                    System.out.println(e.getMessage());
                }
            }
            return oldModel;
        });
    }

    /**
     * The method deletes the present item.
     * @param model to be deleted.
     */
    public void delete(Model model) {
        this.storage.remove(model.getId());
    }

    /**
     * The method returns model.
     * @param id of to be returned.
     * @return model.
     */
    public Model read(long id) {
        return this.storage.get(id);
    }

}