package com.sda.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employer {
    @Id
    @GeneratedValue

    private Long id;


    @OneToOne
    @JoinColumn
    private User user;


    private String info;

    private LocalDate localDate;


}
