/**
 * Package for the test's task's bank transfers tests.
 *
 * 1. You must create a User class with the name, passport.
 * 2. Add methods equals() hashCode ()
 * 3. It is necessary to create an Account class with value fields (amount of money), requisites (account details) is a bank account.
 * 4. Implement the Map <User, List <Account >> collection, which means that each user can have a list of bank accounts.
 * 5. It is necessary to realize the ability to transfer money, both from one User account to another account of the same User, and to the account of another User.
 * 6. The program must have methods:
 *  - public void addUser (User user) {} - add a user.
 *  - public void deleteUser (User user) {} - deletes the user.
 *  - public void addAccountToUser (String passport, Account account) {} - add an account to the user.
 *  - public void deleteAccountFromUser (String passport, Account account) {} - delete one account of the user.
 *  - public List <Accounts> getUserAccounts (String passport) {} - get a list of accounts for the user.
 *  - public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) is a method for transferring money from one account to another account:
 * if the account is not found or there is not enough money on the account srcAccount (from which it is transferred) should return false.
 * 7. Look at the Map.putIfAbsent and List.indexOf methods, how they can be applied in this task.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
package ru.job4j.bank;