package com.astroviking.api.controllers;

import com.astroviking.api.domain.LabProject;
import com.astroviking.api.services.LabProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class LabProjectControllerTest {

  @Mock LabProjectService labProjectService;

  @InjectMocks LabProjectController labProjectController;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(labProjectController).build();
  }

  @Test
  public void testGetAll() throws Exception {
    LabProject labProject1 = new LabProject();
    labProject1.setId(1L);

    Set<LabProject> labProjects = new HashSet<>();
    labProjects.add(labProject1);

    LabProject labProject2 = new LabProject();
    labProject2.setId(2L);

    labProjects.add(labProject2);

    when(labProjectService.findAll()).thenReturn(labProjects);

    mockMvc
        .perform(get(LabProjectController.BASE_URL))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));

    verify(labProjectService, times(1)).findAll();
  }

  @Test
  public void testGetById() throws Exception {
    LabProject labProject1 = new LabProject();
    labProject1.setId(1L);

    when(labProjectService.find(1L)).thenReturn(Optional.of(labProject1));

    mockMvc.perform(get(LabProjectController.BASE_URL + "/1")).andExpect(status().isOk());

    verify(labProjectService, times(1)).find(any());
  }

  @Test
  public void testGetByIdNotFound() throws Exception {
    when(labProjectService.find(1L)).thenReturn(Optional.empty());

    mockMvc.perform(get(LabProjectController.BASE_URL + "/1")).andExpect(status().isNotFound());

    verify(labProjectService, times(1)).find(1L);
  }
}
