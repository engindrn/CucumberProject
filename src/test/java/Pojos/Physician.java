package Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Physician {
    private int id;
    private String firstName;
    private String lastName;
    private String ssn;
    private String examFee;
    private String speciality;

    public Physician() {
    }

    public Physician(int id, String firstName, String lastName, String ssn, String examFee, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.examFee = examFee;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String SSN) {
        this.ssn= SSN;
    }

    public String getExamfee() {
        return examFee;
    }

    public void setExamfee(String examfee) {
        this.examFee = examfee;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "PhysicianApiPojo{" +
                "id='" + id + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", SSN='" + ssn + '\'' +
                ", examfee='" + examFee + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}