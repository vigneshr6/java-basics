package com.vignesh.basics.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable {
    private String firstName;
    private String lastName;
    private int age;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person b = (Person) o;
            if (this.getAge() > b.getAge()) {
                return 1;
            } else if (this.getAge() < b.getAge()) {
                return -1;
            }
        }
        return 0;
    }
}
