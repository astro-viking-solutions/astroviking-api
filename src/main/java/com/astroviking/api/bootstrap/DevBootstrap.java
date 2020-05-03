package com.astroviking.api.bootstrap;

import com.astroviking.api.domain.LabProject;
import com.astroviking.api.repositories.LabProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Profile("development")
@Component
@Slf4j
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private final LabProjectRepository labProjectRepository;

  public DevBootstrap(LabProjectRepository labProjectRepository) {
    this.labProjectRepository = labProjectRepository;
  }

  private void loadLabProjects() {

    if (labProjectRepository.count() > 0) return;

    LabProject labProject1 = new LabProject();
    labProject1.setAppName("Lab Project 1");
    labProject1.setAppDescription(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sed enim eget urna feugiat sollicitudin "
            + "ac id magna. Mauris a condimentum mi. Aenean dictum maximus metus eget ultricies.");

    labProjectRepository.save(labProject1);

    LabProject labProject2 = new LabProject();
    labProject2.setAppName("Lab Project 2");
    labProject2.setAppDescription(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sed enim eget urna feugiat sollicitudin "
            + "ac id magna. Mauris a condimentum mi. Aenean dictum maximus metus eget ultricies.");

    labProjectRepository.save(labProject2);

    LabProject labProject3 = new LabProject();
    labProject3.setAppName("Lab Project 3");
    labProject3.setAppDescription(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sed enim eget urna feugiat sollicitudin "
            + "ac id magna. Mauris a condimentum mi. Aenean dictum maximus metus eget ultricies.");

    labProjectRepository.save(labProject3);

    log.info("Lab Projects loaded: " + labProjectRepository.count());
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    loadLabProjects();
  }
}
