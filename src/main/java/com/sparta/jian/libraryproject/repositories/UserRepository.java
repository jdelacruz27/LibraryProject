package com.sparta.jian.libraryproject.repositories;


import com.sparta.jian.libraryproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT user_id FROM user_entity WHERE user_name =?1", nativeQuery = true)
    Integer findUserIdByName(String name);

    @Query(value = "SELECT user_id, user_name, user_role  FROM user_entity" , nativeQuery = true)
    List<Object[]> getAllUsersByArray();

}
