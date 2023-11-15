package levels;

import models.Employee;
import utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Return the number of employees whose name starts with 'n' */
		long nbr = employees.stream().filter(employee -> employee.getName().toLowerCase().startsWith("n")).count();
		System.out.println("Number of employees whose name starts with 'n': " + nbr);

		/* TO DO 2: Return the sum of salaries of all employees (hint: mapToInt) */
		long sum = employees.stream().mapToInt(employee -> employee.getSalary()).sum();
		System.out.println("Sum of salaries of all employees: " + sum);

		/* TO DO 3: Return the average salary of employees whose name starts with 's' */
		double average = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.mapToDouble(employee -> employee.getSalary())
				.average()
				.orElseGet(() -> 0.0);
		System.out.println("Average salary of employees whose name starts with 's': " + average);

		/* TO DO 4: Return the list of all employees */
		List<Employee> emps = employees.stream().collect(Collectors.toList());
		System.out.println("List of all employees:");
		emps.forEach(System.out::println);

		/* TO DO 5: Return the list of employees whose name starts with 's' */
		List<Employee> emps2 = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.collect(Collectors.toList());
		System.out.println("List of employees whose name starts with 's':");
		emps2.forEach(System.out::println);

		/* TO DO 6: Return true if there is at least one employee whose salary > 1000, false otherwise */
		boolean test = employees.stream().anyMatch(employee -> employee.getSalary() > 1000);
		System.out.println("Is there at least one employee whose salary > 1000? " + test);

		/* TO DO 7: Display the first employee whose name starts with 's' in two different ways */
		/* First way */
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.findFirst().ifPresent(System.out::println);

		/* Second way */
		Employee firstEmployee = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.findFirst().orElse(null);
		if (firstEmployee != null) {
			System.out.println("First employee whose name starts with 's': " + firstEmployee);
		}

		/* TO DO 8: Display the second employee whose name starts with 's' */
		Employee secondEmployee = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.skip(1)
				.findFirst().orElse(null);
		if (secondEmployee != null) {
			System.out.println("Second employee whose name starts with 's': " + secondEmployee);
		}
	}
}