package sm.learning.week2;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@ToString
class Company {
    private String name;
    private Set<Employee> employees = new HashSet<>();
    private Set<Project> projects = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void assignEmployeeToProject(Employee e, Project p) {
        Optional<Employee> employee = employees.stream().filter(x -> x.getId() == e.getId()).findFirst();
        Optional<Project> project = projects.stream().filter(x -> x.getId() == p.getId()).findFirst();
        if (employee.isPresent() && project.isPresent()) {
            e.getProjects().add(project.get());
            p.getEmployees().add(employee.get());
        }
    }

    public void unassignEmployeeFromProject(Employee e, Project p) {
        Optional<Employee> employee = employees.stream().filter(x -> x.getId() == e.getId()).findFirst();
        Optional<Project> project = projects.stream().filter(x -> x.getId() == p.getId()).findFirst();
        if (employee.isPresent() && project.isPresent()) {
            e.getProjects().remove(project.get());
            p.getEmployees().remove(employee.get());
        }
    }

    public void paySalary(Employee e) {
        e.paySalary();
    }

    public void paySalary(Project p) {
        List<Employee> employees = getEmployees().stream().filter(x -> x.getProjects().contains(p)).toList();
        employees.forEach(x -> x.paySalary());
    }

    public void paySalary() {
        getEmployees().forEach(x -> x.paySalary());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("COMPANY: ").append(name).append("\n");
        sb.append("*********************************\n");
        sb.append("Employees: \n");
        getEmployees().stream().sorted().forEach(x -> sb.append(x).append("\n"));
        sb.append("*********************************\n");
        sb.append("Company Projects: \n");
        getProjects().stream().sorted().forEach(x -> sb.append(x).append("\n"));
        return sb.toString();
    }
}
