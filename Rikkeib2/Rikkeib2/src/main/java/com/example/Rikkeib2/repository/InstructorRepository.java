package com.example.Rikkeib2.repository;

import com.example.Rikkeib2.model.Instructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor(1, "Nguyen Van A", "a@test.com"));
    }

    public List<Instructor> findAll() { return instructors; }

    public Instructor findById(int id) {
        return instructors.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(int id, Instructor updated) {
        for (Instructor i : instructors) {
            if (i.getId() == id) {
                i.setName(updated.getName());
                i.setEmail(updated.getEmail());
                return i;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return instructors.removeIf(i -> i.getId() == id);
    }
}