package com.entity;

import javax.persistence.*;

/**
 * Created by Ivanovskiy Alexey on 12.10.2015.
 */
@Entity
@Table(name = "result")
public class Result {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "result", nullable = false)
    private String result;

    @Column(name = "formula", nullable = false)
    private String formula;

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
