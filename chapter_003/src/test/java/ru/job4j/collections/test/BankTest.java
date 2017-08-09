package ru.job4j.collections.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class BankTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {

    /**
     * A link for the bank instance.
     */
    private Bank bank;

    /**
     * A link for the user instance.
     */
    private User user;

    /**
     * Preparing data.
     * @throws Exception if something went wrong.
     */
    @Before
    public void setUp() throws Exception {
        this.bank = new Bank();
        this.user = new User("Andrey", "KE-214587");
    }

    /**
     * Testing method add user to the bank.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenAddUserToBankThanBankHasIt() throws Exception {
        this.bank.addUser(user);
        assertTrue(this.bank.getClients().containsKey(user));
    }

    /**
     * Testing method delete user from the bank.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenDeleteUserThenBankHasNotIt() throws Exception {
        this.bank.addUser(user);
        if (this.bank.getClients().containsKey(user)) {
            this.bank.deleteUser(user);
            assertTrue(!this.bank.getClients().containsKey(user));
        }
    }

    /**
     * Testing method addAccount to the user.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenAddAccountToUserThenUserHasIt() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 0.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        assertTrue(this.bank.getClients().get(user).contains(account));
    }

    /**
     * Testing method deleteAccount from the user.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenDeleteAccountFromUserThenUserHasNotIt() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 0.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        if (this.bank.getClients().get(user).contains(account)) {
            this.bank.deleteAccountFromUser(user, account);
            assertTrue(!this.bank.getClients().get(user).contains(account));
        }
    }

    /**
     * Testing method deleteAccount deletes an account from an invalid user.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenDeleteAccountFromIllegalUserThenUnsupportedOperationException() throws Exception {
        this.bank.addUser(null);
        Account account = new Account("usd", 0.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        if (this.bank.getClients().get(user).contains(account)) {
            this.bank.deleteAccountFromUser(user, account);
            assertTrue(!this.bank.getClients().get(user).contains(account));
        }
    }

    /**
     * Testing method deleteAccount deletes an invalid account from from the user.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenDeleteIllegalAccountFromUserThenUnsupportedOperationException() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 0.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, null);
        if (this.bank.getClients().get(user).contains(account)) {
            this.bank.deleteAccountFromUser(user, account);
            assertTrue(!this.bank.getClients().get(user).contains(account));
        }
    }

    /**
     * Testing method transferMoney from the source user to the destination user.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTransferMoneyIsValidThenTrue() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 100.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        User destUser = new User("Ivan", "KE-214587");
        Account destAccount = new Account("usd", 10.0, "9876_5432_1012_3456");
        this.bank.addUser(destUser);
        this.bank.addAccountToUser(destUser, destAccount);
        assertTrue(this.bank.transferMoney(user, account, destUser, destAccount, 40.0));
    }

    /**
     * Testing method transferMoney between the source user to the destination user when isn't enough source money.
     * @throws Exception if something went wrong.
     */
    @Test()
    public void whenTransferMoneyIsInValidThenFalse() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 100.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        User destUser = new User("Ivan", "KE-214587");
        Account destAccount = new Account("usd", 10.0, "9876_5432_1012_3456");
        this.bank.addUser(destUser);
        this.bank.addAccountToUser(destUser, destAccount);
        assertFalse(this.bank.transferMoney(user, account, destUser, destAccount, 200.0));
    }

    /**
     * Testing method transferMoney between the user's accounts when is enough source money.
     * @throws Exception if something went wrong.
     */
    @Test()
    public void whenTransferMoneyBetweenOneUserIsValidThenTrue() throws Exception {
        this.bank.addUser(user);
        Account account = new Account("usd", 100.0, "1234_1234_1234_1234");
        this.bank.addAccountToUser(user, account);
        Account destAccount = new Account("usd", 10.0, "9876_5432_1012_3456");
        this.bank.addAccountToUser(user, destAccount);
        assertTrue(this.bank.transferMoney(user, account, user, destAccount, 40.0));
    }
}