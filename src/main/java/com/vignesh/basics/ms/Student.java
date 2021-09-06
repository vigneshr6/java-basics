package com.vignesh.basics.ms;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private LocalDate dob;
    private List<String> preferredSubjects;

    public Student(int id,String name,LocalDate dob,List<String> preferredSubjects) {
        this.id=id;
        this.name=name;
        this.dob=dob;
        this.preferredSubjects=preferredSubjects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public final List<String> getPreferredSubjects() {
        return Collections.unmodifiableList(preferredSubjects);
    }
}
