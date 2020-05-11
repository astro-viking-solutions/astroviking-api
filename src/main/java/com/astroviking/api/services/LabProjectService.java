package com.astroviking.api.services;

import com.astroviking.api.domain.LabProject;
import com.astroviking.api.repositories.LabProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LabProjectService {

  private final LabProjectRepository labProjectRepository;

  public Set<LabProject> findAll() {
    Set<LabProject> labProjects = new HashSet<>();
    labProjectRepository.findAll().forEach(labProjects::add);
    return labProjects;
  }

  public Optional<LabProject> find(Long id) {
    return labProjectRepository.findById(id);
  }
}
