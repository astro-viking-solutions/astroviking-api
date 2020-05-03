package com.astroviking.api.repositories;

import com.astroviking.api.domain.LabProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabProjectRepository extends CrudRepository<LabProject, Long> {}
