package model;

import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String email;
    private long acc;

    public User() {
    }

    public User(String name, String email, long acc) {
        this.name = name;
        this.email = email;
        this.acc = acc;
    }

    public User(long id, String name, String email, long acc) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.acc = acc;
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

    public String getMail() {
        return email;
    }

    public void setMail(String email) {
        this.email = email;
    }

    public long getAcc() {
        return acc;
    }
    public void setAcc(long acc) {
        this.acc = acc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAcc(), that.getAcc()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAcc(), getMail(), getId());
    }
}
