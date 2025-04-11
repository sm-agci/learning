package sm.learning.week2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString
class ContractEmployee extends Employee {
    private String firstName;
    private String lastName;

    @Override
    public void paySalary() {
        log.debug("[{} {}] Paying salary: {}", firstName, lastName, getSalary());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getProjects() != null) {
            getProjects().forEach(x -> sb.append(x).append("\n"));
        }
        return String.format("[%d]%-10s -> salary: %.2f %nProjects: %s %n", getId(), firstName + " " + lastName, getSalary(), sb);
    }
}
