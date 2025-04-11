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
class B2BEmployee extends Employee {
    private String companyName;
    private double tax;

    @Override
    public void paySalary() {
        double fullSalary = getSalary() + getSalary() * tax;
        log.debug("[{}] Paying salary: {}", companyName, fullSalary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(getProjects() != null) {
            getProjects().forEach(x -> sb.append(x).append("\n"));
        }
        return String.format("[%d]%-10s -> salary: %.2f, tax: %.2f %nProjects: %s %n", getId(), companyName, getSalary(), getTax(), sb);
    }
}
