package com.kik.repo;

import com.kik.model.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepo extends JpaRepository<Parameter, Long> {
}
