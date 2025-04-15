package sm.learning.week2;

import lombok.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode()
@ToString
@Builder
class Project implements Comparable<Project>, Payable {
    private int id;
    private String name;

    @Builder.Default
    private Set<Employee> employees = new HashSet<>();

    @Override
    public int compareTo(Project other) {
        return Integer.compare(this.id, other.getId());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getEmployees() != null) {
            getEmployees().forEach(x -> sb.append(x.getId()).append(","));
        }
        return String.format("[%d] Name: %-10s -> project employees: %s", getId(), name, sb);

    }

    @Override
    public void paySalary() {
        employees.forEach(x -> x.paySalary());
    }

    public void addEmployee(Employee e) {
            e.addProject(this);
            employees.add(e);
    }

    public void removeEmployee(Employee e) {
        Optional<Employee> employee = employees.stream().filter(x -> x.getId() == e.getId()).findFirst();
        if (employee.isPresent()) {
            employees.remove(e);
            e.removeProject(this);
        }
    }
}
