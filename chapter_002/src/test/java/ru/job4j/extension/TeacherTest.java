package ru.job4j.extension;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Class TeacherTest describes tests for class Teacher.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class TeacherTest {
    /**
     *  A current student under Test.
     */
    private static Human student;
    /**
     *  A current teacher under Test.
     */
    private static Teacher teacher;
    /**
     *  A current task under Test.
     */
    private static Task task;

    /**
     * Set up initialisation date.
     * @throws Exception if something goes wrong.
     */
    @BeforeClass
    public static void setUp() {
        student = new Human("Alex");
        teacher = new Teacher("Petr", "programmer",
                "highSchool", 10, "master");
        task = new Task("The extension");
    }

    /**
     * Testing teach method.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTeachThenReturnInformLine() throws Exception {
        assertEquals("A teacher Petr teaches the student Alex of a subject Java programming",
                TeacherTest.teacher.teach(TeacherTest.student, "Java programming"));
    }

    /**
     * Testing consultation method.
     * @throws Exception  if something goes wrong.
     */
    @Test
    public void whenConsultationStudentThenReturnInformLine() throws Exception {
        assertEquals("A teacher Petr consults a student Alex by The extension task",
                TeacherTest.teacher.consultationStudent(student, task));
    }

    /**
     * Testing method of give a task.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveTaskThenReturnInformLine() throws Exception {
        assertEquals("A teacher Petr gives a task to a student Alex of a task The extension",
                TeacherTest.teacher.giveTask(student, task));
    }

    /**
     * Testing method of check a task.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenCheckTaskThenReturnGrade() throws Exception {
        assertEquals(5, TeacherTest.teacher.checkTask(student, task));

    }

}