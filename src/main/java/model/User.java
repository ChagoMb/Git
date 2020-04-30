package model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "acc")
    private long acc;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String name, String email, String password, long acc, String role) {
        this.name = name;
        this.email = email;
        this.acc = acc;
        this.password = password;
        this.role = role;
    }

    public User(long id, String name, String email, String password, long acc, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.acc = acc;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAcc(), that.getAcc()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAcc(), getMail(),
                getId(), getPassword(), getRole());
    }
}
