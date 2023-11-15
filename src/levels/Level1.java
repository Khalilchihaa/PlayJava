package levels;

import models.Employee;
import utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Afficher tous les employés */
		// Print all employees
		employees.forEach(System.out::println);

		/*
		 * TO DO 2: Afficher les employés dont le nom commence par la lettre n
		 */
		// Filter employees whose name starts with the letter 'n'
		List<Employee> filteredEmployees = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("n"))
				.collect(Collectors.toList());

		filteredEmployees.forEach(System.out::println);

		/*
		 * TO DO 3: Afficher les employés dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
		// Filter employees whose name starts with the letter 'n' and salary > 1000
		filteredEmployees = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("n") && employee.getSalary() > 1000)
				.collect(Collectors.toList());

		// Print filtered employees
		filteredEmployees.forEach(System.out::println);

		/*
		 * TO DO 4: Afficher les employés dont le nom commence par la lettre s
		 * triés par salaire
		 */
		// Filter employees whose name starts with the letter 's'
		filteredEmployees = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.collect(Collectors.toList());

		// Sort filtered employees by salary
		filteredEmployees.sort(Comparator.comparing(Employee::getSalary));

		// Print sorted employees
		filteredEmployees.forEach(System.out::println);

		/*
		 * TO DO 5: Afficher les noms des employés dont le salaire > 600 avec 2
		 * maniéres différentes
		 */
		// First Way: Filter employees with salary > 600 and get their names
		List<String> employeeNames = employees.stream()
				.filter(employee -> employee.getSalary() > 600)
				.map(Employee::getName)
				.collect(Collectors.toList());

		// Print employee names
		employeeNames.forEach(System.out::println);

		// Second Way: Filter employees with salary > 600 and get their names
		employeeNames = employees.stream()
				.filter(employee -> employee.getSalary() > 600)
				.map(employee -> employee.getName())
				.collect(Collectors.toList());

		// Print employee names
		employeeNames.forEach(System.out::println);

		/*
		 * TO DO 6: Ajouter 200 D pour les employés dont le nom commence avec m
		 * et les affichés ensuite
		 */
		// Filter employees whose name starts with 'm', increment their salary by 200, and print them
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("m"))
				.peek(employee -> employee.setSalary(employee.getSalary() + 200))
				.forEach(System.out::println);
	}
}