package com.itstep.ppjava13v1.prepod.academy.db.entities;

import java.util.Date;

/**
 * Created by strazhko on 26.07.14.
 */
public abstract class Stuff {
    Date start;
    Date finish;
    Person person;

    public Stuff(Date start, Date finish, Person person) {
        this.start = start;
        this.finish = finish;
        this.person = person;
    }

    public Stuff() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stuff stuff = (Stuff) o;

        if (finish != null ? !finish.equals(stuff.finish) : stuff.finish != null) return false;
        if (person != null ? !person.equals(stuff.person) : stuff.person != null) return false;
        if (start != null ? !start.equals(stuff.start) : stuff.start != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }
}
