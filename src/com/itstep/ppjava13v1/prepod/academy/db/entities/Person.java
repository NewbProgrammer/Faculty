package com.itstep.ppjava13v1.prepod.academy.db.entities;

import java.util.*;

public class Person {

    private long id;
    private String name;
    private Date birthday;
    private String passport;
    private Set<Student> studentList = new HashSet<Student>();
    private Set<Teacher> teacherList = new HashSet<Teacher>();

    public Person(String name, Date birthday, String passport) {
        this.name = name;
        this.birthday = birthday;
        this.passport = passport;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public boolean addStudent(Student s) {
        return studentList.add(s);
    }

    public boolean addTeacher(Teacher t) {
        return teacherList.add(t);
    }

    public boolean removeStudent(Student s){
        return studentList.remove(s);
    }

    public boolean removeTeacher(Teacher s){
        return teacherList.remove(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (passport != null ? !passport.equals(person.passport) : person.passport != null) return false;
        if (studentList != null ? !studentList.equals(person.studentList) : person.studentList != null) return false;
        if (teacherList != null ? !teacherList.equals(person.teacherList) : person.teacherList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (studentList != null ? studentList.hashCode() : 0);
        result = 31 * result + (teacherList != null ? teacherList.hashCode() : 0);
        return result;
    }
}
