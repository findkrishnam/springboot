package com.krishnamg.app.dao;

import com.krishnamg.app.model.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<System, Long> {
}
