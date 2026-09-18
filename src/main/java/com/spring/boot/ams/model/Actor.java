package com.spring.boot.ams.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "actors")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Actor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name ="actor_name", nullable = false)
    private String name;

    @Column(name = "actor_age", nullable = false)
    private int age;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "industry", nullable = false)
    private String industry;
}
