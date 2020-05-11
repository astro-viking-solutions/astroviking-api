package com.astroviking.api.controllers;

import com.astroviking.api.domain.LabProject;
import com.astroviking.api.services.LabProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(LabProjectController.BASE_URL)
public class LabProjectController {

  public static final String BASE_URL = "/labs";

  private LabProjectService labProjectService;

  @GetMapping
  public Set<LabProject> getLabs() {
    return labProjectService.findAll();
  }

  @GetMapping("/{id}")
  public LabProject getLab(@PathVariable Long id) {
    return labProjectService
        .find(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lab Project not found."));
  }
}
