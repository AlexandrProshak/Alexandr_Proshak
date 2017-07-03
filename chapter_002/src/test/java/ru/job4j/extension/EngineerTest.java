package ru.job4j.extension;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class EngineerTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
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
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTakePartInMeetingThenReturnLineOfMeeting() throws Exception {
        assertEquals("An engineer Max takes a part in a meeting Agile",
                EngineerTest.engineer.takePartInMeeting("Agile"));
    }

    /**
     * Testing studying documentation of a project.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenStudyDocumentationOfProjectThenReturnInformationLine() throws Exception {
        assertEquals("An engineer Max has been studying documentation of a project New Function 5 часов",
                EngineerTest.engineer.studyDocumentationOfProject(this.project, 5));
    }

    /**
     * Testing a consultation method.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void consultationColleague() throws Exception {
        assertEquals("An engineer Max consults a colleague Jack",
                EngineerTest.engineer.consultationColleague(EngineerTest.colleague));
    }

    /**
     * Testing a method of doing a project.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenDoProjectThenIncreaseTimeOfProject() throws Exception {
        assertEquals(10, EngineerTest.engineer.doProject(this.project, 10).getTime());
        assertEquals(30, EngineerTest.engineer.doProject(this.project, 20).getTime());

    }

    /**
     * Testing a method of fixing a project.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenFixProjectThenIncreaseTimeOfProject() throws Exception {
        assertEquals(10, EngineerTest.engineer.fixProject(this.project, 10).getTime());
    }

    /**
     * Testing a method of earned a salary.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void earnedSalary() throws Exception {
        EngineerTest.engineer.earnedSalary(2000f, project);
        float engineerSalery = EngineerTest.engineer.getSalary();
        float projectMoney = this.project.getMoney();
        assertTrue(2000f == engineerSalery);
        assertTrue(2000f == projectMoney);
    }

}