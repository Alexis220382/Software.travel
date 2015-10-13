package com.entity;

import javax.persistence.*;

/**
 * Created by Ivanovskiy Alexey on 12.10.2015.
 */
@Entity
@Table(name = "formula")
public class Formula {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description", nullable = false)
    private int description;

    public Formula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}