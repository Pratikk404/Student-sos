package com.studentsos.studentsos.repository;

import com.studentsos.studentsos.entity.SosRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SosRepository extends JpaRepository<SosRequest, Long> {
}