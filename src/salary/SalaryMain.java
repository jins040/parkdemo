package salary;

import salary.model.Salaries;
import salary.service.SalaryService;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalaryMain {

    public static void main(String[] args) {

        List<Salaries> list = SalaryService.makeListFromCSV("src\\Salaries.csv");

        // 1. 1900년대 평균 연봉 (1985~1999)
        OptionalDouble averageIn1900s =
                list.stream()
                    .filter(x -> x.getYearID().getYear() < 2000)
                    //.peek(System.out::println)
                    .mapToInt(x -> x.getSalary())
                    //.peek(System.out::println)
                    .average();

        System.out.printf("1. 1985~1999년도 평균 연봉은 %.2f달러입니다.\n\n", averageIn1900s.getAsDouble());

        // 2. 전체 레코드의 평균 연봉
        OptionalDouble totalAverage =
                list.stream()
                        .mapToInt(x -> x.getSalary())
                        .average();
        System.out.printf("2. 전체 평균 연봉은 %.2f달러입니다.\n\n", totalAverage.getAsDouble());

        // 3. 최고 연봉자와 최소 연봉자
        Salaries playerWithMaxSalary =
                list.stream()
                        .sorted((x, y) -> y.getSalary() - x.getSalary())
                        .findFirst()
                        .get();

        Salaries playerWithMinSalary =
                list.stream()
                        //.sorted((x, y) -> x.getSalary() - y.getSalary())
                        .sorted(Comparator.comparingInt(Salaries::getSalary))
                        .findFirst()
                        .get();

        System.out.printf("3. 최고 연봉자는 %s (%d달러), 최소 연봉자는 %s (%d달러)입니다.\n\n",
                playerWithMaxSalary.getPlayerID(), playerWithMaxSalary.getSalary(),
                playerWithMinSalary.getPlayerID(), playerWithMinSalary.getSalary());

        // 4. NL 최고 연봉
        OptionalInt mostSalaryOfNL =
                list.stream()
                        .filter(x -> x.getLgID().equals("NL"))
                        .mapToInt(x -> x.getSalary())
                        .max();

        System.out.printf("4. NL 최고 연봉은 %d 입니다.\n\n", mostSalaryOfNL.getAsInt());

        // 5. NYY 구단의 평균 연봉
        OptionalDouble averageSalaryOfNYY =
                list.stream()
                        .filter(x -> x.getTeamID().equals("NYY"))
                        .mapToInt(x -> x.getSalary())
                        .average();

        System.out.printf("5. NYY 구단의 평균 연봉은 %.2f 달러입니다.\n\n", averageSalaryOfNYY.getAsDouble());

        // 6. 최상위 연봉자 10명의 평균
        OptionalDouble averageSalaryOfBest10Salaries =
                list.stream()
                        .sorted((x, y) -> y.getSalary() - x.getSalary())
                        .limit(10)
                        .mapToInt(x -> x.getSalary())
                        .average();

        System.out.printf("6. 최상위 연봉자 10명의 평균은 %.2f 달러입니다.\n\n", averageSalaryOfBest10Salaries.getAsDouble());

    }
}
