package com.github.lorellw.socialNetworkRest.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
@Data
public class User {

    @Id
    private String id;
}
