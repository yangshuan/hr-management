package com.oomlife.hr.common.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by yangshuan on 15/12/8.
 */
public class Department {
    private long id;
    private String name;
    private String desc;
    private Status status;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    private long lastUpdatedBy;
    private Date lastUpdatedTime;
    private long createdBy;
    private Date createdTime;


    @OneToMany
    @JoinTable(
            name = "employee_department",
            joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> employees;
}
