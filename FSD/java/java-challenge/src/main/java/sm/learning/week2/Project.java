package sm.learning.week2;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode()
@ToString
@Builder
class Project implements Comparable<Project> {
    private int id;
    private String name;

    private Set<Employee> employees;

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
}
