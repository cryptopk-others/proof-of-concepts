package com.sivalabs.sgdemo.repositories

import com.sivalabs.sgdemo.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by skatam on 18-12-2014.
 */
@Repository
interface UserRepository extends JpaRepository<User, Integer>{

}