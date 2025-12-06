package com.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notifications.models.DbProperty;

@Repository
public interface DbPropertiesRepository extends JpaRepository<DbProperty, Integer> {

}
