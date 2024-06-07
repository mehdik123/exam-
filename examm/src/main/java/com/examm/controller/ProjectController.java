package com.examm.controller;

import com.examm.entities.Employee;
import com.examm.entities.EmployeeProject;
import com.examm.entities.Project;
import com.examm.service.EmployeeService;
import com.examm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/manager/projects")
    public String showProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "projects"; // JSP view
    }

    @PostMapping("/manager/assign")
    public String assignProject(@RequestParam Long projectId, @RequestParam Long employeeId, @RequestParam int implication) {
        Project project = projectService.findById(projectId);
        Employee employee = employeeService.findById(employeeId);

        if (project != null && employee != null) {
            EmployeeProject employeeProject = new EmployeeProject();
            employeeProject.setProject(project);
            employeeProject.setEmployee(employee);
            employeeProject.setImplication(implication);

            employeeService.assignProject(employeeProject);
        }

        return "redirect:/manager/projects";
    }

    @GetMapping("/employee-list")
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employeeList"; // Thymeleaf view
    }

    @GetMapping("/api/employees")
    @Secured({"ROLE_DEV", "ROLE_TEST", "ROLE_DEVOPS"})
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/api/projects")
    @Secured({"ROLE_DEV", "ROLE_TEST", "ROLE_DEVOPS"})
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
}
