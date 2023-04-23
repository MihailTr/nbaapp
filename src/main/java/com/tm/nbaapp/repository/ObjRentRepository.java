package com.tm.nbaapp.repository;

import com.tm.nbaapp.model.ObjRent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjRentRepository extends JpaRepository<ObjRent, Long> {
    List<ObjRent> findByUserId(Long id);
}
