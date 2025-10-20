package edu.fra.uas.hello.noten;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service  // wichtig: macht die Klasse zu einer Bean!
public class GradeService {

    private final List<Grade> grades = new ArrayList<>();

    public void addGrade(String subject, double grade, int ects) {
        grades.add(new Grade(subject, grade, ects));
    }

    public double average() {
        if (grades.isEmpty()) return 0.0;
        return grades.stream().mapToDouble(Grade::getGrade).average().orElse(0.0);
    }

    public double weightedAverage() {
        int ectsSum = grades.stream().mapToInt(Grade::getEcts).sum();
        if (ectsSum == 0) return 0.0;
        double sum = grades.stream().mapToDouble(g -> g.getGrade() * g.getEcts()).sum();
        return sum / ectsSum;
    }

    public List<Grade> getAll() {
        return grades;
    }
}
