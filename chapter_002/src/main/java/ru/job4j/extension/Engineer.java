package ru.job4j.extension;

/**
 * The class Engineer describes a profession of an engineer.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    /**
     * science degree.
     */
    private String degree;
    /**
     * existence of own projects.
     */
    private boolean ownProjects;
    /**
     * access level.
     */
    private int accessLevel;

    /**
     * A simple constructor.
     */
    public Engineer() {
    }

    /**
     * The constructor with parameters.
     * @param name name of an engineer.
     * @param specialization of an engineer.
     * @param graduatedSchool finished school of an engineer.
     * @param experience amount years working as an engineer.
     * @param degree science degree of an engineer (middle, senior).
     */
    public Engineer(String name, String specialization, String graduatedSchool, int experience, String degree) {
        super(name, specialization, graduatedSchool, experience);
        this.degree = degree;
    }

    /**
     * A meeting's activity.
     * @param nameOfMeeting name of a meeting.
     * @return an information line of an engineer activity on meeting.
     */
    public String takePartInMeeting(String nameOfMeeting) {
        return "An engineer " + this.getName() + " takes a part in a meeting "
                + nameOfMeeting;
    }

    /**
     * Studying documentation of a project.
     * @param project of studying.
     * @param time spent for studying.
     * @return an information line about studying.
     */
    public String studyDocumentationOfProject(Project project, int time) {
        return "An engineer " + this.getName() + " has been studying a projects  "
                + project.getName() + " documentation " + time + " часов";
    }

    /**
     * Consultation colleague.
     * @param colleague for consultation with.
     * @return line of information about consultation colleague.
     */
    public String consultationColleague(Colleague colleague) {
        return "An engineer " + this.getName()
                + " консультировал колегу " + colleague.getName();
    }

    /**
     * Doing project.
     * @param project for doing.
     * @param time was spent for work.
     * @return finished project.
     */
    public Project doProject(Project project, int time) {
        project.setTime(time);
        return project;
    }

    /**
     * Fixing project.
     * @param project for fixing.
     * @param time was spent for work.
     * @return fixed project.
     */
    public Project fixProject(Project project, int time) {
        project.setTime(time);
        return project;
    }

    /**
     * Calculation salary for engineer.
     * @param amount of money.
     * @param project of paid.
     */
    protected void earnedSalary(float amount, Project project) {
        project.setMoney(amount);
        this.setSalary(amount);
    }
}