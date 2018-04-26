package ru.job4j.parser.dao;

import ru.job4j.parser.model.Vacancy;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The interface describes the contract of the vacancy's behavior with the database.
 */
public interface VacancyDao {

    /**
     * The method adds an item to the db.
     * @param connection to db.
     * @param vacancies to be added.
     */
    void saveVacancies(final Connection connection, final BlockingQueue<Vacancy> vacancies);

    /**
     * The method removes an vacancy from a db.
     * @param connection to db.
     * @param id of the vacancy to be deleted.
     * @return true in case of success, false otherwise.
     */
    boolean deleteVacancyById(final Connection connection, final int id);

    /**
     * The method finds the vacancies by the id.
     * @param connection to db.
     * @param id of the vacancy to be searched.
     * @return the vacancy.
     */
    Vacancy findItemById(final Connection connection, final int id);

    /**
     * The method finds all vacancies by the name.
     * @param connection to db.
     * @return list of vacancies with a similar name.
     */
    List<Vacancy> showAllVacancy(final Connection connection);

    /**
     * The method retrieve from db the date of last update.
     * @param connection to db.
     * @return date
     */
    Timestamp getLastUpdate(Connection connection);

    /**
     * The method updates the date of the last update.
     * @param connection to db.
     * @param time to update.
     */
    void updateLustTimeUpdate(Connection connection, Timestamp time);

}
