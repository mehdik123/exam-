package com.examm.service;

import com.examm.entities.Project;
import com.examm.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }
}
