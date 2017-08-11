package ru.job4j.collections.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Bank {

    /**
     * A Map of bank's clients.
     */
    private Map<User, List<Account>> clients;

    /**
     * A constructor.
     */
    public Bank() {
        this.clients = new HashMap<>();
    }

    /**
     * A getter for clients.
     * @return a map of bank's clients.
     */
    public Map<User, List<Account>> getClients() {
        return clients;
    }

    /**
     * A method is adding an user to the bank's client's map.
     * @param user to add.
     */
    public void addUser(User user) {
        if (user != null) {
            Account emptyAccount = new Account("empty", 0.0, "0000 0000 0000 0000");
            user.addUserAccounts(emptyAccount);
            this.clients.put(user, user.getUserAccountList());
        } else {
            throw new UnsupportedOperationException("An invalid user to add");
        }
    }

    /**
     * A method is deleting a given user.
     * @param user to delete from the bank.
     */
    public void deleteUser(User user) {
        if (valid(user)) {
            this.clients.remove(user);
        }
    }

    /**
     * A method is adding new account to current user.
     * @param user for adding an account.
     * @param account to add.
     */
    public void addAccountToUser(User user, Account account) {
        if (valid(user, account)) {
            user.addUserAccounts(account);
        }
    }

    /**
     * A method is deleting an account from current user.
     * @param user to refresh.
     * @param account to delete.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (valid(user, account)) {
            boolean result = user.removeAccountFromList(account);
            if (!result) {
                throw new UnsupportedOperationException("An invalid account");
            }
        } else {
            throw new UnsupportedOperationException(String.format(
                    "Account %s does not belong to this user %s", account.getRequisites(), user.getName()));
        }
    }

    /**
     * A method transfers money from source account to the destination account.
     * @param srcUser source user.
     * @param srcAccount source account.
     * @param dstUser destination user.
     * @param dstAccount destination account.
     * @param amount of money to transfer.
     * @return true if everything went fine.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        if (valid(srcUser, srcAccount)
                && valid(dstUser, dstAccount)
                && srcAccount.getCurrency().equalsIgnoreCase(dstAccount.getCurrency())) {

            List<Account> srcListOfAccount = this.clients.get(srcUser);
            boolean srcInclude = srcListOfAccount.contains(srcAccount);
            List<Account> dstListOfAccount = this.clients.get(dstUser);
            boolean dstInclude = dstListOfAccount.contains(dstAccount);

            if (srcInclude && dstInclude) {
                if (srcAccount.getValue() > amount) {
                    double srcCheck = srcAccount.getValue();
                    double dstCheck = dstAccount.getValue();
                    dstAccount.increaseValue(amount);
                    srcAccount.increaseValue(-amount);
                    if (dstAccount.getValue() == dstCheck + amount && srcAccount.getValue() == srcCheck - amount) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * An overloaded method valid for user.
     * @param user to validation.
     * @return true if user is not null and is present in the bank.
     */
    private boolean valid(User user) {
        if (user == null) {
            throw new UnsupportedOperationException("An invalid user");
        }
        if (!this.clients.containsKey(user)) {
            throw new UnsupportedOperationException(String.format(
                    "%s is not a customer of our bank", user.getName()));
        }
        return true;
    }

    /**
     * A method checking user.
     * @param user to check.
     * @param account to check.
     * @return true when user and account are valid.
     */
    private boolean valid(User user, Account account) {
        if (user == null) {
            throw new UnsupportedOperationException("An invalid user");
        }
        if (account == null) {
            throw new UnsupportedOperationException("An invalid account");
        }
        if (!this.clients.containsKey(user)) {
            throw new UnsupportedOperationException(String.format(
                    "%s is not a customer of our bank", user.getName()));
        }
        return true;
    }
}
