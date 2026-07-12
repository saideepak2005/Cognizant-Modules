package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    private static EmployeeService employeeService;

    private static DepartmentService departmentService;

    private static SkillService skillService;

    private static AttemptService attemptService;

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {

        LOGGER.info("Inside main");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        attemptService = context.getBean(AttemptService.class);

        testGetAllCountries();

        testGetCountryByCode();

        testAddCountry();

        testUpdateCountry();

        testDeleteCountry();

        testGetEmployee();

        testAddEmployee();

        testUpdateEmployee();

        testGetDepartment();

        testAddSkillToEmployee();

        testGetAllPermanentEmployees();

        testAverageSalary();

        testGetAllEmployeesNative();

        testGetAttempt();

    }


    private static void testGetAllCountries() {

        LOGGER.info("Start testGetAllCountries");

        List<Country> countries = countryService.getAllCountries();

        System.out.println(countries);

        LOGGER.info("End testGetAllCountries");

    }

    private static void testGetCountryByCode() {

        LOGGER.info("Start testGetCountryByCode");

        try {

            Country country = countryService.findCountryByCode("IN");

            System.out.println(country);

        } catch (CountryNotFoundException e) {

            System.out.println(e.getMessage());

        }

        LOGGER.info("End testGetCountryByCode");

    }

    private static void testAddCountry() {

        LOGGER.info("Start testAddCountry");

        Country country = new Country("ZZ", "TestCountry");

        countryService.addCountry(country);

        try {

            Country fetched = countryService.findCountryByCode("ZZ");

            System.out.println(fetched);

        } catch (CountryNotFoundException e) {

            System.out.println(e.getMessage());

        }

        LOGGER.info("End testAddCountry");

    }

    private static void testUpdateCountry() {

        LOGGER.info("Start testUpdateCountry");

        countryService.updateCountry("ZZ", "UpdatedTestCountry");

        try {

            Country fetched = countryService.findCountryByCode("ZZ");

            System.out.println(fetched);

        } catch (CountryNotFoundException e) {

            System.out.println(e.getMessage());

        }

        LOGGER.info("End testUpdateCountry");

    }

    private static void testDeleteCountry() {

        LOGGER.info("Start testDeleteCountry");

        countryService.deleteCountry("ZZ");

        LOGGER.info("End testDeleteCountry");

    }

    private static void testGetEmployee() {

        LOGGER.info("Start testGetEmployee");

        Employee employee = employeeService.get(1);

        System.out.println(employee);

        if (employee != null) {

            System.out.println(employee.getDepartment());
            System.out.println(employee.getSkillList());

        }

        LOGGER.info("End testGetEmployee");

    }

    private static void testAddEmployee() {

        LOGGER.info("Start testAddEmployee");

        Employee employee = new Employee();

        employee.setEmpName("John Doe");
        employee.setEmpSalary(75000.0);
        employee.setEmpPermanent(true);
        employee.setEmpDateOfBirth(java.sql.Date.valueOf("1995-05-15"));

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);

        LOGGER.info("End testAddEmployee");

    }

    private static void testUpdateEmployee() {

        LOGGER.info("Start testUpdateEmployee");

        Employee employee = employeeService.get(1);

        if (employee != null) {

            Department department = departmentService.get(2);
            employee.setDepartment(department);
            employeeService.save(employee);
            System.out.println(employee);

        }

        LOGGER.info("End testUpdateEmployee");

    }

    private static void testGetDepartment() {

        LOGGER.info("Start testGetDepartment");

        Department department = departmentService.get(1);

        System.out.println(department);

        if (department != null) {

            Set<Employee> employees = department.getEmployeeList();
            System.out.println(employees);

        }

        LOGGER.info("End testGetDepartment");

    }

    private static void testAddSkillToEmployee() {

        LOGGER.info("Start testAddSkillToEmployee");

        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(3);

        if (employee != null && skill != null) {

            employee.getSkillList().add(skill);
            employeeService.save(employee);
            System.out.println(employee);

        }

        LOGGER.info("End testAddSkillToEmployee");

    }

    private static void testGetAllPermanentEmployees() {

        LOGGER.info("Start testGetAllPermanentEmployees");

        List<Employee> list = employeeService.getAllPermanentEmployees();

        System.out.println(list);

        for (Employee e : list) {

            System.out.println(e.getSkillList());

        }

        LOGGER.info("End testGetAllPermanentEmployees");

    }

    private static void testAverageSalary() {

        LOGGER.info("Start testAverageSalary");

        Double average = employeeService.getAverageSalary(1);

        System.out.println(average);

        LOGGER.info("End testAverageSalary");

    }

    private static void testGetAllEmployeesNative() {

        LOGGER.info("Start testGetAllEmployeesNative");

        List<Employee> list = employeeService.getAllEmployeesNative();

        System.out.println(list);

        LOGGER.info("End testGetAllEmployeesNative");

    }

    private static void testGetAttempt() {

        LOGGER.info("Start testGetAttempt");

        Attempt attempt = attemptService.getAttempt(1, 1);

        if (attempt != null) {

            System.out.println("User : " + attempt.getUser().getUserName());
            System.out.println("Date : " + attempt.getAttemptDate());

            for (AttemptQuestion aq : attempt.getQuestionList()) {

                Question q = aq.getQuestion();
                System.out.println("Question: " + q.getQuestionText());

                for (Option o : q.getOptionList()) {

                    System.out.println(o.getOptionText() + " " + o.getOptionScore());

                }

            }

        }

        LOGGER.info("End testGetAttempt");

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("--- FB Stocks September 2019 ---");

        stockRepository.findByStockCodeAndStockDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        ).forEach(System.out::println);

        System.out.println("--- GOOGL Stocks Close > 1250 ---");

        stockRepository.findByStockCodeAndStockCloseGreaterThan(
                "GOOGL",
                new BigDecimal("1250.00")
        ).forEach(System.out::println);

        System.out.println("--- Top 3 Highest Volume Stocks ---");

        stockRepository.findTop3ByOrderByStockVolumeDesc().forEach(System.out::println);

        System.out.println("--- Netflix 3 Lowest Stocks ---");

        stockRepository.findTop3ByStockCodeOrderByStockCloseAsc("NFLX").forEach(System.out::println);

    }

}

