package sm.learning.week2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ChallengeWeek2 {

    public void runCompany() {
        Company company = Company.builder().name("SM").build();
        //log.debug("Company status: \n{}", company);

        B2BEmployee john = B2BEmployee.builder().id(1).companyName("John B2B").salary(12000).taxRate(10.5).build();
        B2BEmployee mark = B2BEmployee.builder().id(2).companyName("Mark B2B").salary(7500).taxRate(7).build();
        ContractEmployee clara = ContractEmployee.builder().id(3).firstName("Clara").lastName("Doe").salary(10000).build();
        ContractEmployee eli = ContractEmployee.builder().id(4).firstName("Eli").lastName("Elo").salary(14000).build();

        company.addEmployee(john);
        company.addEmployee(mark);
        company.addEmployee(clara);
        company.addEmployee(eli);

        Project ukProject = Project.builder().id(1).name("uk-run").build();
        Project usProject = Project.builder().id(2).name("us-run").build();
        Project deProject = Project.builder().id(3).name("de-run").build();

        company.addProject(ukProject);
        company.addProject(usProject);
        company.addProject(deProject);

        log.debug("Company status: \n{}", company);

        ukProject.addEmployee(mark);
        ukProject.addEmployee(john);
        ukProject.addEmployee(clara);
        deProject.addEmployee(eli);

        log.debug("Company status: \n{}", company);

        log.debug("Paying to employees from project: {}", ukProject);
        ukProject.paySalary();
        log.debug("Paying to employees from project: {} ", usProject);
        usProject.paySalary();
        log.debug("Paying to employee: {}", john);
        john.paySalary();
        log.debug("Paying to employee: {}", clara);
        clara.paySalary();
        log.debug("Paying to all");
        company.paySalary();

        log.debug("Reassign {} from: {} to: {}", eli, deProject, ukProject);
        company.reassignEmployee(eli, deProject, ukProject);
        ukProject.removeEmployee(john);
        log.debug("Company status: \n{}", company);
    }
}
