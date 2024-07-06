package com.conference.management.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private int age;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "is_reviewer_enable_to_review")
    private boolean is_reviewer_enable_to_review;

    @Column(name = "is_reviewer_has_not_assignment")
    private boolean is_reviewer_has_not_assignment;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_professions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_name"))
    private List<Profession> professions;

    public User(){

    }

    public User(String password, String name, String surname, String phone, String mail, int age, boolean enabled, boolean is_reviewer_enable_to_review, boolean is_reviewer_has_not_assignment, Collection<Role> roles, List<Profession> professions) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.enabled = enabled;
        this.is_reviewer_enable_to_review = is_reviewer_enable_to_review;
        this.is_reviewer_has_not_assignment = is_reviewer_has_not_assignment;
        this.roles = roles;
        this.professions = professions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isIs_reviewer_enable_to_review() {
        return is_reviewer_enable_to_review;
    }

    public void setIs_reviewer_enable_to_review(boolean is_reviewer_enable_to_review) {
        this.is_reviewer_enable_to_review = is_reviewer_enable_to_review;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public boolean isIs_reviewer_has_not_assignment() {
        return is_reviewer_has_not_assignment;
    }

    public void setIs_reviewer_has_not_assignment(boolean is_reviewer_has_not_assignment) {
        this.is_reviewer_has_not_assignment = is_reviewer_has_not_assignment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", enabled=" + enabled +
                ", reviewer_enabled_to_review=" + is_reviewer_enable_to_review +
                ", reviewer_enable_to_assignment=" + is_reviewer_has_not_assignment +
                ", roles=" + roles +
                ", professions=" + professions +
                '}';
    }
}
