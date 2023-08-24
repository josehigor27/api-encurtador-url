package com.springboot.apiurl.repositories;

import com.springboot.apiurl.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UrlRepository extends JpaRepository<UrlModel, UUID> {
}
