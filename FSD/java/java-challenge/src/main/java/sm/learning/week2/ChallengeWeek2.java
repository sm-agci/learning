package sm.learning.week2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;


@Slf4j
@Component
public class ChallengeWeek2 {

    public void runCompany() {
        Company company = new Company("SM");
        //log.debug("Company status: \n{}", company);

        B2BEmployee john = B2BEmployee.builder().id(1).companyName("John B2B").salary(12000).tax(10.5).projects(new HashSet<>()).build();
        B2BEmployee mark = B2BEmployee.builder().id(2).companyName("Mark B2B").salary(7500).tax(7).projects(new HashSet<>()).build();
        ContractEmployee clara = ContractEmployee.builder().id(3).firstName("Clara").lastName("Doe").salary(10000).projects(new HashSet<>()).build();
        ContractEmployee eli = ContractEmployee.builder().id(4).firstName("Eli").lastName("Elo").salary(14000).projects(new HashSet<>()).build();

        company.addEmployee(john);
        company.addEmployee(mark);
        company.addEmployee(clara);
        company.addEmployee(eli);

        Project ukProject = Project.builder().id(1).name("uk-run").employees(new HashSet<>()).build();
        Project usProject = Project.builder().id(2).name("us-run").employees(new HashSet<>()).build();
        Project deProject = Project.builder().id(3).name("de-run").employees(new HashSet<>()).build();

        company.addProject(ukProject);
        company.addProject(usProject);
        company.addProject(deProject);

        log.debug("Company status: \n{}", company);

        company.assignEmployeeToProject(mark, ukProject);
        company.assignEmployeeToProject(john, ukProject);
        company.assignEmployeeToProject(clara, ukProject);
        company.assignEmployeeToProject(eli, deProject);

        log.debug("Company status: \n{}", company);

        log.debug("Paying to employees from project: {}", ukProject);
        company.paySalary(ukProject);
        log.debug("Paying to employees from project: {} ", usProject);
        company.paySalary(usProject);
        log.debug("Paying to employee: {}", john);
        company.paySalary(john);
        log.debug("Paying to all");
        company.paySalary();


        company.unassignEmployeeFromProject(eli, deProject);

        log.debug("Company status: \n{}", company);
    }
}
