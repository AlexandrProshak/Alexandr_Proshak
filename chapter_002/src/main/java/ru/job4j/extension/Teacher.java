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
     * science degree.
     */
    private String degree;

    /**
     * Constructor.
     */
    public Teacher() {
    }

    /**
     * Constructor with parametes.
     * @param name of teacher
     * @param specialization of teacher
     * @param graduatedSchool high school of finished by
     * @param experience of working as a teacher
     * @param degree science degree
     */
    public Teacher(String name, String specialization, String graduatedSchool, int experience, String degree) {
        super(name, specialization, graduatedSchool, experience);
        this.degree = degree;
    }

    /**
     * teaching a student by subject.
     * @param student for teaching
     * @param subject of teaching
     */
    public void teach(Human student, String subject) {
        System.out.println("Учитель " + this.getName() + " учит студента " + student.getName() + " предмету " + subject);
    }

    /**
     * consultation a student by subject.
     * @param student for teaching
     * @param subject of teaching
     */
    public void consultationStudent(Human student, String subject) {
        System.out.println("Учитель " + this.getName() + " консультирует студента " + student.getName() + " предмету " + subject);
    }

    /**
     * a method of giving a task for a student.
     * @param student for task
     * @param task for student
     */
    public void giveTask(Human student, Task task) {
        System.out.println("Учитель " + this.getName() + " дает задание студенту " + student.getName() + " предмету " + task.getName());
    }

    /**
     * a method of checking a task and return an evaluation of task.
     * @param student for task
     * @param task for student
     * @return garade for task (1-5)
     */
    public int checkTask(Human student, Task task) {
        int grade = 5;
        return grade;
    }
}
