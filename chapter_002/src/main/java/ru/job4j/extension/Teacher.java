package ru.job4j.extension;

/**
 * Class Teacher describes a profession of a teacher.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * A science degree.
     */
    private String degree;

    /**
     * A simple constructor.
     */
    public Teacher() {
    }

    /**
     * A constructor with parameters.
     * @param name of a teacher.
     * @param specialization of a teacher.
     * @param graduatedSchool high school was graduated by a teacher.
     * @param experience of working as a teacher.
     * @param degree science degree.
     */
    public Teacher(String name, String specialization, String graduatedSchool, int experience, String degree) {
        super(name, specialization, graduatedSchool, experience);
        this.degree = degree;
    }

    /**
     * Teaching a student by subject.
     * @param student for teaching
     * @param subject of teaching
     */
    public void teach(Human student, String subject) {
        System.out.println("A teacher " + this.getName() + " teaches the student "
                + student.getName() + " of a subject " + subject);
    }

    /**
     * consultation a student by subject.
     * @param student for teaching
     * @param subject of teaching
     */
    public void consultationStudent(Human student, String subject) {
        System.out.println("A teacher " + this.getName() + " consults a student "
                + student.getName() + " of a subject " + subject);
    }

    /**
     * Giving a task for a student.
     * @param student for a task.
     * @param task for a student.
     */
    public void giveTask(Human student, Task task) {
        System.out.println("A teacher " + this.getName() + " gives a task to a student "
                + student.getName() + " of a task " + task.getName());
    }

    /**
     * Checking a task and return an evaluation of task.
     * @param student for a task.
     * @param task for a student.
     * @return grade for a task (1-5).
     */
    public int checkTask(Human student, Task task) {
        int grade = 5;
        return grade;
    }
}
