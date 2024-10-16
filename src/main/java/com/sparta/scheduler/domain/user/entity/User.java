package com.sparta.scheduler.domain.user.entity;

import com.sparta.scheduler.domain.task.entity.Timestamped;
import jakarta.persistence.*;

@Entity
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String email;

}
