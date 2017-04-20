import model.Park;
import service.ParkService;

import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkSortingDemo {

    public static void main(String[] args) {

        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");

        System.out.println(list.size());    // original size

        long count = list.parallelStream()
                .sorted((x, y) -> x.getParkKey().compareTo(y.getParkKey()))
                .filter(x -> !x.getCity().startsWith("B"))
                .count();
                //.forEach(x -> System.out.println(x));

        System.out.println(count);


    }// main 끝
}
