package org.easyspring.test.entity;

import org.easyspring.stereotype.Component;

/**
 * @author tancunshi
 */
@Component(value = "user")
public class Person {
    private String name;
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
