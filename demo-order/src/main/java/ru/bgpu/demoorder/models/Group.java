package ru.bgpu.demoorder.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    public static final String GROUP_ADMIN = "ADMIN";
    public static final String GROUP_USER = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();
}
