package com.example.Rikkeib2.repository;

import com.example.Rikkeib2.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1, "Hoc Vien A", 101));
        enrollments.add(new Enrollment(2, "Hoc Vien B", 102));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Enrollment findById(int id) {
        return enrollments.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(int id, Enrollment updatedEnrollment) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                enrollment.setStudentName(updatedEnrollment.getStudentName());
                enrollment.setCourseId(updatedEnrollment.getCourseId());
                return enrollment;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return enrollments.removeIf(enrollment -> enrollment.getId() == id);
    }
}