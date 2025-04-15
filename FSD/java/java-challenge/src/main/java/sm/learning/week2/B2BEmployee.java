package sm.learning.week2;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString
class B2BEmployee extends Employee{
    private String companyName;
    private double taxRate;

    @Override
    public void paySalary() {
        log.debug("[{}] Receiving salary: {}", companyName, getSalary());
        payTax();
    }

    public void payTax() {
        double tax = getSalary() * taxRate/100;
        log.debug("[{}] Paying tax: {}", companyName, tax);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(getProjects() != null) {
            getProjects().forEach(x -> sb.append(x).append("\n"));
        }
        return String.format("[%d]%-10s -> salary: %.2f, tax: %.2f %nProjects: %s %n", getId(), companyName, getSalary(), getTaxRate(), sb);
    }
}
