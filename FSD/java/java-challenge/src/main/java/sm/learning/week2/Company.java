package sm.learning.week2;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@Builder
class Company {
    private String name;
    @Builder.Default
    private Set<Employee> employees = new HashSet<>();
    @Builder.Default
    private Set<Project> projects = new HashSet<>();
    public void addProject(Project project) {
        projects.add(project);
    }
    public void removeProject(Project project) {
        projects.remove(project);
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void reassignEmployee(Employee employee, Project fromProject, Project toProject) {
        if (fromProject != null) {
            fromProject.removeEmployee(employee);
        }
        toProject.addEmployee(employee);
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
        getEmployees().stream().sorted().forEach(x -> sb.append(x));
        sb.append("*********************************\n");
        sb.append("Company Projects: \n");
        getProjects().stream().sorted().forEach(x -> sb.append(x).append("\n"));
        return sb.toString();
    }
}
