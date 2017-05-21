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
     * @return an information line.
     */
    public String teach(Human student, String subject) {
        return String.format("A teacher %s teaches the student %s of a subject %s",
                this.getName(), student.getName(), subject);
    }

    /**
     * Consultation a student by task.
     * @param student for teaching
     * @param task of teaching
     * @return an information line.
     */
    public String consultationStudent(Human student, Task task) {
        return String.format("A teacher %s consults a student %s by %s task",
                this.getName(), student.getName(), task.getName());
    }

    /**
     * Giving a task for a student.
     * @param student for a task.
     * @param task for a student.
     * @return an information line.
     */
    public String giveTask(Human student, Task task) {
        return String.format("A teacher %s gives a task to a student %s of a task %s",
                this.getName(), student.getName(), task.getName());
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
