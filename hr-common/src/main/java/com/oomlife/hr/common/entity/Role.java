package com.oomlife.hr.common.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Each button or menu should be a role
 * Created by yangshuan on 15/12/8.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String name;
    @Column
    private String desc;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private long lastUpdatedBy;
    @Temporal(TemporalType.TIME)
    private Date lastUpdatedTime;
    @Column(nullable = false)
    private long createdBy;
    @Temporal(TemporalType.TIME)
    private Date createdTime;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;
}
