package sm.learning.week2;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@SuperBuilder
abstract class Employee implements Comparable<Employee>, Payable {
    private int id;
    private double salary;
    @Builder.Default
    private Set<Project> projects = new HashSet<>();

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.getId());
    }

    public void addProject(Project e) {
        projects.add(e);
    }

    public void removeProject(Project p) {
        Optional<Project> project = projects.stream().filter(x -> x.getId() == p.getId()).findFirst();
        if (project.isPresent()) {
            projects.remove(p);
        }
    }
}
