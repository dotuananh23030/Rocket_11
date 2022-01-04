package com.techprimers.kafka.springbootkafkaconsumerexample.model;

public class User {

    private String name;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String dept) {
        this.subject = subject;
    }

    public User() {
    }

    public User(String name, String subject) {

        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
