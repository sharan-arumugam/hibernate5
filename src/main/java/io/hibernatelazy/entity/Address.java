package io.hibernatelazy.entity;

import static io.hibernatelazy.Constants.STUDENT;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@ToString(callSuper = false, exclude = "student")
@Entity
@Table
public class Address implements Serializable {

    private static final long serialVersionUID = 5828317842141606707L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Short flat;
    private Short floor;
    private String community;
    private String street;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = STUDENT)
    private Student student;
}
