package ru.job4j.task1;

/**
 * The class Doctor describes a profession of a doctor.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Doctor extends Profession {
    /**
     * Number of a diploma.
     */
    private String diplomaNumber;
    /**
     * A simple constructor.
     */
    public Doctor() {
    }

    /**
     * The constructor with parameters.
     * @param name of doctor.
     * @param specialization of doctor.
     * @param graduatedSchool high school was graduated by a doctor.
     * @param experience year working as a doctor.
     * @param diplomaNumber number of diploma.
     */
    public Doctor(String name, String specialization,
                  String graduatedSchool, int experience,
                  String diplomaNumber) {
        super(name, specialization, graduatedSchool, experience);
        this.diplomaNumber = diplomaNumber;
    }

    /**
     * Diagnostic patient.
     * @param patient for diagnostic.
     * @return diagnose for the given patient.
     */
    public String diagnose(Human patient) {
        return String.format("Doctor %s diagnostics %s",
                this.getName(), patient.getName());
    }

    /**
     * Treating patient.
     * @param patient for treating.
     * @return an information line of treating.
     */
    public String treat(Human patient) {
        return String.format("Doctor %s treats %s",
                this.getName(), patient.getName());
    }

    /**
     * Writing a diagnose of a patient for a drugstore.
     * @param patient for writing a recipe.
     * @param diagnose of a patient for writing .
     * @return a line with recipe.
     */
    public String writeOutRecipe(Human patient, String diagnose) {
        return String.format("Doctor %s have written a recipe %s based on diagnose of %s",
                this.getName(), patient.getName(), diagnose);
    }

}
