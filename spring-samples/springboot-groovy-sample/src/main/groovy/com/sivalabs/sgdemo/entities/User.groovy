package com.sivalabs.sgdemo.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Siva on 18-12-2014.
 */
@Entity
@Table(name="users")
class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    @Column(nullable = false, unique = true)
    String name
    @Column(nullable = false, unique = true)
    String email
    @Column(nullable = false)
    String password

}
