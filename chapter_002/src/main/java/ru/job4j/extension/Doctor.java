package ru.job4j.extension;

/**
 * Class Doctor.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    /**
     * number of diploma.
     */
    private String diplomsNumber;
    /**
     * Constructor.
     */
    public Doctor() {
    }

    /**
     * Constructor.
     * @param name of doctor.
     * @param specialization of doctor.
     * @param graduatedSchool high school.
     * @param experience year working as a doctor.
     * @param diplomsNumber number of diploma.
     */
    public Doctor(String name, String specialization, String graduatedSchool, int experience, String diplomsNumber) {
        super(name, specialization, graduatedSchool, experience);
        this.diplomsNumber = diplomsNumber;
    }

    /**
     * Diagnostic.
     * @param patient for diagnostic.
     * @return diagnose.
     */
    public String diagnose(Human patient) {
        return "доктор " + this.getName() + " ставит диагноз " + patient.getName();
    }

    /**
     * Treating patient.
     * @param patient for treating.
     * @return line of treating.
     */
    public String treat(Human patient) {
        return "доктор " + this.getName() + " лечит " + patient.getName();
    }

    /**
     * Writing diagnose for drugstore.
     * @param patient for writing.
     * @param diagnose for writing.
     * @return diagnose.
     */
    public String writeOutRecipe(Human patient, String diagnose) {
        return "доктор " + this.getName() + " выписал рецепт " + patient.getName() + " по диагнозу " + diagnose;
    }

}
