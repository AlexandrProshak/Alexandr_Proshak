package ru.job4j.task2.dao;

import ru.job4j.task2.model.Vacancy;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The interface describes the contract of the vacancy's behavior with the database.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public interface VacancyDao {

    /**
     * The method adds an item to the db.
     * @param vacancies to be added.
     */
    void saveVacancies(final BlockingQueue<Vacancy> vacancies);

    /**
     * The method removes an vacancy from a db.
     * @param id of the vacancy to be deleted.
     * @return true in case of success, false otherwise.
     */
    boolean deleteVacancyById(final int id);

    /**
     * The method finds the vacancies by the id.
     * @param id of the vacancy to be searched.
     * @return the vacancy.
     */
    Vacancy findItemById(final int id);

    /**
     * The method finds all vacancies by the name.
     * @return list of vacancies with a similar name.
     */
    List<Vacancy> showAllVacancy();

    /**
     * The method retrieve from db the date of last update.
     * @return date
     */
    Timestamp getLastUpdate();

    /**
     * The method updates the date of the last update.
     * @param time to update.
     */
    void updateLustTimeUpdate(Timestamp time);

}
