package ru.job4j.extension;

/**
 * Engineer describes a profession of a engineer.
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
     * Constructor.
     */
    public Engineer() {
    }

    /**
     * Constructor.
     * @param name name of engineer.
     * @param specialization of engineer.
     * @param graduatedSchool finished school of engineer.
     * @param experience amount of years working as an engineer.
     * @param degree of engineer (middle, senior).
     */
    public Engineer(String name, String specialization, String graduatedSchool, int experience, String degree) {
        super(name, specialization, graduatedSchool, experience);
        this.degree = degree;
    }

    /**
     * a method of meeting activity.
     * @param nameOfMeeting name meeting.
     * @return line with meetings name.
     */
    public String takePartInMeeting(String nameOfMeeting) {
        return this.getName() + "берет участие в митинге " + nameOfMeeting;
    }

    /**
     * a method of studying documentation activity.
     * @param project of studying.
     * @param time spent for studying.
     * @return line of information about studying documentation.
     */
    public String studyDocumentationOfProject(Project project, int time) {
        return this.getName() + " изучал документацию о проекте "
                + project.getName() + time + " часов";
    }

    /**
     *  a method of consultation colleague.
     * @param colleague for consultation with.
     * @return line of information about consultation colleague.
     */
    public String consultationColleague(Colleague colleague) {
        return this.getName() + " консультировал колегу " + colleague.getName();
    }

    /**
     *  a method of doing project.
     * @param project for doing.
     * @param time spent for work.
     * @return finished project.
     */
    public Project doProject(Project project, int time) {
        project.setTime(time);
        return project;
    }

    /**
     *  a method of fixing project.
     * @param project for fixing.
     * @param time spent for fix.
     * @return fixed project.
     */
    public Project fixProject(Project project, int time) {
        project.setTime(time);
        return project;
    }

    /**
     * calculation salary for engineer.
     * @param amount of money.
     * @param project of paid.
     */
    protected void earnedSalary(float amount, Project project) {
        project.setMoney(amount);
        this.setSalary(amount);
    }
}
