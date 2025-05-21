package org.training;

import java.util.List;
import java.util.Objects;

public class User {
    String name;
    int id;
    int age ;
    String role;
    String location;
    List<Long> contactNumbers;

    public User(String name, int id, int age, String role, String location, List<Long> contactNumbers) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.role = role;
        this.location = location;
        this.contactNumbers = contactNumbers;
    }

    public User(String name, int id, int age, String role, String location) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.role = role;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Long> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<Long> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(role, user.role) && Objects.equals(location, user.location) && Objects.equals(contactNumbers, user.contactNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age, role, location, contactNumbers);
    }
}
