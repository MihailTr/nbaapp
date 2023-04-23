package com.tm.nbaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ObjRent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String area;
    private String details;
    private String photo;
    private String price;
    private String rentTime;
    private String rooms;
    private String status;
    private String title;
    private String type;

    @ManyToOne
    private User user;
}
