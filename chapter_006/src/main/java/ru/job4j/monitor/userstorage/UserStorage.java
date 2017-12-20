package ru.job4j.monitor.userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * The class UserStorage describes storage for users.
 */
@ThreadSafe
public class UserStorage {

    /**
     * The Map for storing users.
     */
    private final Map<Integer, User> storage;

    /**
     * A constructor.
     */
    public UserStorage() {
        this.storage = new HashMap<>();
    }

    /**
     * The method adds new user to the storage.
     * @param user new user to be added.
     * @return true in case of success or false otherwise.
     */
    @GuardedBy("this.storage")
    public boolean add(User user) {
        synchronized (this.storage) {
            if (user == null) {
                return false;
            }
            return this.storage.putIfAbsent(user.getId(), user) != null;
        }
    }

    /**
     * A method updates user in the storage.
     * @param user to be updated.
     * @return true in case of success or false otherwise.
     */
    @GuardedBy("this.storage")
    public boolean update(User user) {
        synchronized (this.storage) {
            if (user == null || !this.storage.containsKey(user.getId())) {
                return false;
            }
            return this.storage.computeIfPresent(user.getId(), (k, v) ->
                    this.storage.replace(user.getId(), user)) != null;
        }
    }

    /**
     * The method deletes given user ih case it is present in the storage.
     * @param user to be deleted.
     * @return true in case of success or false otherwise.
     */
    @GuardedBy("this.storage")
    public boolean delete(User user) {
        synchronized (this.storage) {
            if (user == null) {
                return false;
            }
            return this.storage.remove(user.getId(), user);
        }
    }

    /**
     * The method transfers an amount of money form one user to another.
     * @param fromId donor user.
     * @param toId recipient user.
     * @param amount of money.
     * @return true in case of success or false otherwise.
     */
    @GuardedBy("this.storage")
    public boolean  transfer(int fromId, int toId, int amount) {
        synchronized (this.storage) {
            if (!this.storage.containsKey(fromId)
                    || !this.storage.containsKey(toId)
                    || this.storage.get(fromId).getAmount() < amount) {
                return false;
            }

            User creditor = this.storage.get(fromId);
            User recipient = this.storage.get(toId);

            int donorAmount = creditor.getAmount();
            int recipientAmount = recipient.getAmount();

            int newDonorAmount = donorAmount - amount;
            int newRecipientAmount = recipientAmount + amount;

            this.storage.get(fromId).setAmount(newDonorAmount);
            this.storage.get(toId).setAmount(newRecipientAmount);
            return true;
        }
    }

    /**
     * The method prints storage.
     */
    @GuardedBy("this.storage")
    public void printStorage() {
        synchronized (this.storage) {
            for (User each : this.storage.values()) {
                System.out.println(" id " + each.getId() + " amount " + each.getAmount());
            }
        }
    }
}
