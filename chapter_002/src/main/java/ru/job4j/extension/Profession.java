package ru.job4j.extension;

/**
 * Class Profession.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public abstract class Profession extends Human {
    /**
     * specialization of humans being.
     */
    private String specialization;
    /**
     * high school graduated by humans being.
     */
    private String graduatedSchool;
    /**
     * experience of humans being.
     */
    private int experience;
    /**
     * wage for work accepted by humans being.
     */
    private float salary = 0.0f;

    /**
     * Constructor.
     */
    protected Profession() {
    }

    /**
     * Constructor.
     * @param name for super class.
     * @param specialization for super class.
     * @param graduatedSchool for super class.
     * @param experience for super class.
     */
    protected Profession(String name, String specialization, String graduatedSchool, int experience) {
        super(name);
        this.specialization = specialization;
        this.graduatedSchool = graduatedSchool;
        this.experience = experience;
    }
    /**
     * a method increase a field of a salary.
     * @param amount of money per month for work.
     * @param month was paid.
     */
    protected void earnedSalary(float amount, String month) {
        this.salary = amount;
    }

    /**
     * Seter salary.
     * @param salary wage for work.
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
