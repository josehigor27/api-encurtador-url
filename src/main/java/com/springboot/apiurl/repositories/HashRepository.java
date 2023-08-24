package com.springboot.apiurl.repositories;

import com.springboot.apiurl.model.HashModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashRepository extends JpaRepository<HashModel, String> {
}
