package ru.job4j.task1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class DoctorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class DoctorTest {

    /**
     * A current doctor.
     */
    private static Doctor doc;

    /**
     * A current patient.
     */
    private static Human patient;

    /**
     * Set up initialisation date.
     */
    @BeforeClass
    public static void setUp() {
        DoctorTest.doc = new Doctor("House", "diagnostician",
                "VSM", 20, "KB-2410");
        DoctorTest.patient = new Human("John");
    }

    /**
     * Testing diagnose method.
     */
    @Test
    public void whenDocDiagnosticsPatientThenReturnLineOfDiagnose() {
        assertEquals("Doctor House diagnostics John", DoctorTest.doc.diagnose(DoctorTest.patient));
    }

    /**
     * Testing treat method.
     */
    @Test
    public void whenDocTreatsPatientThenReturnLineOfTreating() {
        assertEquals("Doctor House treats John", DoctorTest.doc.treat(DoctorTest.patient));
    }

    /**
     * Testing writing recipe method.
     */
    @Test
    public void whenDocWriteOutRecipeForPatientThenReturnLineOfRecipe() {
        assertEquals("Doctor House have written a recipe John "
                + "based on diagnose of volchanca",
                DoctorTest.doc.writeOutRecipe(DoctorTest.patient, "volchanca"));
    }

}