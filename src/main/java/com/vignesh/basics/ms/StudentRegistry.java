package com.vignesh.basics.ms;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StudentRegistry {
    private static StudentRegistry instance = null;
    private List<Student> students = new CopyOnWriteArrayList<>();

    private StudentRegistry(){}

    public StudentRegistry getInstance() {
        if(instance == null) {
            synchronized (StudentRegistry.class) {
                if(instance == null) {
                    instance = new StudentRegistry();
                }
            }
        }
        return instance;
    }

    public synchronized void addStudent(Student s) throws StudentRegistryException{
        try {
            students.add(s);
        } catch(Exception e) {
            throw new StudentRegistryException("Exception:addStudent--"+e.getMessage());
        }
    }

}
