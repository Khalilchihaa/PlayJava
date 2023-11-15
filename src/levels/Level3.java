package levels;

import models.Employee;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import utils.Data;
//import static jdk.nashorn.internal.objects.NativeArray.map;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();


		/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
		String names = employees.stream()
				.map(e -> e.getName())
				.reduce("", (n1, n2) -> n1 + "#" + n2);
		/* TO DO 1  hint(reduce)*/

		/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */

		String namesMajSplit = employees.stream().map(e -> e.getName().toUpperCase()).collect(Collectors.joining("#"));


		/* TO DO 2 */

		/* TO DO 3: Retourner une set d'employ�s*/


		Set<Employee> emps = employees.stream().collect(Collectors.toSet());

		/* TO DO 3 */

		/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(
						() -> new TreeSet<>(
								(e1, e2) -> e1.getName().compareTo(e2.getName())
						)
				));
		/* TO DO 4 */

		/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */

		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getSalary()));
		/* TO DO 5 */

		/* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
		Map<Integer, String> mm = employees.stream()
				.collect(
						Collectors.groupingBy(
								e -> e.getSalary(),
								Collectors.mapping(
										e -> e.getName(),
										Collectors.joining(",")
								)
						)
				);
		/*TO DO 6*/

		/* TO DO 7: Retourner le  min, max,average, sum,count des salaires */

		String s = employees.stream()
				.mapToInt(e -> e.getSalary())
				.summaryStatistics()
				.toString();

		/* TO DO 7 */


	}
}