package org.training;

import java.util.Objects;

public class Employee {
    String name;
    int id;
    String role;
    String location;
    long mobile;



    public Employee(String name, int id, String role, String location, long mobile) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.location = location;
        this.mobile = mobile;
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

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && mobile == employee.mobile && Objects.equals(name, employee.name) && Objects.equals(role, employee.role) && Objects.equals(location, employee.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getRole(), getLocation(), getMobile());
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', role='" + role + "', location='" + location + "', mobile=" + mobile + "}";
    }
}
