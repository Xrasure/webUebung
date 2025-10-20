package edu.fra.uas.hello.noten;

public class Grade {
    private final String subject;
    private final double grade;
    private final int ects;

    public Grade(String subject, double grade, int ects) {
        this.subject = subject;
        this.grade = grade;
        this.ects = ects;
    }

    public String getSubject() { return subject; }
    public double getGrade() { return grade; }
    public int getEcts() { return ects; }
}