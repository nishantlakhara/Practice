package designpatterns;

import java.util.Objects;

public final class Student {
    private final int rollNo;
    private final String name;
    private final Address permanentAddress;

    public Student(int rollNo, String name, Address permanentAddress) {
        this.rollNo = rollNo;
        this.name = name;
        this.permanentAddress = permanentAddress;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

//    public Address getPermanentAddress() {
//        //return new Address(permanentAddress);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo &&
                Objects.equals(name, student.name) &&
                Objects.equals(permanentAddress, student.permanentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name, permanentAddress);
    }
}
