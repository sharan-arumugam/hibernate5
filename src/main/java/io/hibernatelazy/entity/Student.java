package io.hibernatelazy.entity;

import static io.hibernatelazy.Constants.STUDENT;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Student implements Serializable {

    private static final long serialVersionUID = 1722908608310928944L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = STUDENT, cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<Address> address;

}
