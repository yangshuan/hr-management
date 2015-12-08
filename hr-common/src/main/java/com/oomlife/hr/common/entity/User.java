package com.oomlife.hr.common.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The user of the system
 * each employee should have at least one user id
 * Created by yangshuan on 15/12/8.
 */
@Entity
public class User {
    @Id
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private Long lastUpdatedBy;
    @Temporal(TemporalType.TIME)
    private Date lastUpdatedTime;
    @Column(nullable = false)
    private Long createdBy;
    @Temporal(TemporalType.TIME)
    private Date createdTime;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;
}
