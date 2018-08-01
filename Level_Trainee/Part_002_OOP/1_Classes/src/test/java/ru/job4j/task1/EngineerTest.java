package ru.job4j.task1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class EngineerTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class EngineerTest {

    /**
     * A current engineer under Test.
     */
    private static Engineer engineer;

    /**
     * A current project under Test.
     */
    private Project project;

    /**
     * A current colleague under Test.
     */
    private static Colleague colleague;

    /**
     * Set up initialisation date.
     */
    @BeforeClass
    public static void setUp() {
        EngineerTest.engineer = new Engineer("Max", "programmer",
                "KPI", 3, "middle");
        EngineerTest.colleague = new Colleague("Scot");
        EngineerTest.colleague = new Colleague("Jack");
    }

    /**
     * Set up initialisation date of project.
     */
    @Before
    public void setUpProject() {
        this.project = new Project("New Function");
    }

    /**
     * Testing a meeting activity.
     */
    @Test
    public void whenTakePartInMeetingThenReturnLineOfMeeting() {
        assertEquals("An engineer Max takes a part in a meeting Agile",
                EngineerTest.engineer.takePartInMeeting("Agile"));
    }

    /**
     * Testing studying documentation of a project.
     */
    @Test
    public void whenStudyDocumentationOfProjectThenReturnInformationLine() {
        assertEquals("An engineer Max has been studying documentation of a project New Function 5 часов",
                EngineerTest.engineer.studyDocumentationOfProject(this.project, 5));
    }

    /**
     * Testing a consultation method.
     */
    @Test
    public void consultationColleague() {
        assertEquals("An engineer Max consults a colleague Jack",
                EngineerTest.engineer.consultationColleague(EngineerTest.colleague));
    }

    /**
     * Testing a method of doing a project.
     */
    @Test
    public void whenDoProjectThenIncreaseTimeOfProject() {
        assertEquals(10, EngineerTest.engineer.doProject(this.project, 10).getTime());
        assertEquals(30, EngineerTest.engineer.doProject(this.project, 20).getTime());

    }

    /**
     * Testing a method of fixing a project.
     */
    @Test
    public void whenFixProjectThenIncreaseTimeOfProject() {
        assertEquals(10, EngineerTest.engineer.fixProject(this.project, 10).getTime());
    }

    /**
     * Testing a method of earned a salary.
     */
    @Test
    public void earnedSalary() {
        EngineerTest.engineer.earnedSalary(2000f, project);
        float engineerSalery = EngineerTest.engineer.getSalary();
        float projectMoney = this.project.getMoney();
        assertTrue(2000f == engineerSalery);
        assertTrue(2000f == projectMoney);
    }

}