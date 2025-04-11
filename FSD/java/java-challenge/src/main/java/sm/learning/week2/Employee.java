package sm.learning.week2;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@SuperBuilder
abstract class Employee implements Comparable<Employee> {
    private int id;
    private double salary;
    private Set<Project> projects;

    public abstract void paySalary();

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.getId());
    }
}
