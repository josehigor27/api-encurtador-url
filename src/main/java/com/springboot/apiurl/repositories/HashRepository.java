package com.springboot.apiurl.repositories;

import com.springboot.apiurl.model.HashModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Deprecated
@Repository
public interface HashRepository extends JpaRepository<HashModel, String> {

}
