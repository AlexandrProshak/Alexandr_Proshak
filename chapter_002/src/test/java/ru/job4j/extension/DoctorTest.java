package ru.job4j.extension;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Class DoctorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
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
     * @throws Exception if something goes wrong.
     */
    @BeforeClass
    public static void setUp() throws Exception {
        DoctorTest.doc = new Doctor("House", "diagnostician",
                "VSM", 20, "KB-2410");
        DoctorTest.patient = new Human("John");
    }

    /**
     * Testing diagnose method.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenDocDiagnosticsPatientThenReturnLineOfDiagnose() throws Exception {
        assertEquals("Doctor House diagnostics John", DoctorTest.doc.diagnose(DoctorTest.patient));
    }

    /**
     * Testing treat method.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenDocTreatsPatientThenReturnLineOfTreating() throws Exception {
        assertEquals("Doctor House treats John", DoctorTest.doc.treat(DoctorTest.patient));
    }

    /**
     * Testing writing recipe method.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenDocWriteOutRecipeForPatientThenReturnLineOfRecipe() throws Exception {
        assertEquals("Doctor House have written a recipe John "
                + "based on diagnose of volchanca",
                DoctorTest.doc.writeOutRecipe(DoctorTest.patient, "volchanca"));
    }

}