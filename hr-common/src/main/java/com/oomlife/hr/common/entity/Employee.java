package com.oomlife.hr.common.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    private long id;
    private String name;
    private int age;
    private Sex sex;
    private String idNumber;
    private Email workEmail;
    private Email personalEmail;

    @Column(nullable = false)
    private EmployeeStatus status;
    private Date onBoardDate;
    private Date leaveDate;

    private long reportTo;

    @ManyToOne(
        optional = false
    )
    @JoinTable(
            name = "employee_department",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private Department department;

    @Column(nullable = false)
    private long lastUpdatedBy;
    @Temporal(TemporalType.TIME)
    private Date lastUpdatedTime;
    @Column(nullable = false)
    private long createdBy;
    @Temporal(TemporalType.TIME)
    private Date createdTime;

    public enum Sex {
        Male, Female;
    }

    public class Email {
        private String username;
        private String domainName;

        public Email(String username, String domainName) {
            this.username = username;
            this.domainName = domainName;
        }

        public String getUsername() {
            return username;
        }

        public String getDomainName() {
            return domainName;
        }

        @Override
        public String toString() {
            return username + "@" + domainName;
        }
    }

    public enum EmployeeStatus {
        OnBoarding, Active, Leave;
    }
}
