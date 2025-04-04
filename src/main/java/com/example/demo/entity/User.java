package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity // Annotation to tell Hibernate that this class is an entity and should be persisted in the database
@Table(name = "users") // table name in the database. If we don't specify it, the table name will be the same as the Entity name. If not specified, the Entity name is the same as the class name
public class User {

    @Id // Annotation to tell Hibernate that this field is the primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate will generate new ids for us. GenerationType.IDENTITY will use the database's auto-increment feature (will increment the id by 1)
    private long id;
    private String name;
    private String email;
    private int age;

    @OneToOne(cascade = CascadeType.ALL) // CascadeType.ALL will propagate all operations (CRUD) to the related entity (table). This means that if we delete a User, the related Address will also be deleted. If we update a User, the related Address will also be updated.
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // mappedBy is used to specify the field name in the Order class that owns the relationship
    private List<Order> orders;

    @Transient // marks the field as transient (non-serializable), meaning it will NOT be persisted in the database (can be used for various business logic, etc.). Usually not needed. Also, not needed in our case, put here only for demo purposes
    private String ignoredByDb;

    protected User() {
        // Hibernate needs a non-arg constructor (at least protected), otherwise it will fail
    }

    // helper constructor used for business logic in the service layer
    public User(String name, String email, int age, Address address, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.orders = orders;
    }

    // getters and setters for all fields needed for Hibernate to work properly

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getIgnoredByDb() {
        return ignoredByDb;
    }

    public void setIgnoredByDb(String ignoredByDb) {
        this.ignoredByDb = ignoredByDb;
    }
}
