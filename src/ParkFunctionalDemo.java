import service.ParkService;

import java.util.Collections;
import java.util.List;

import model.Park;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo {

    public static void main(String[] args) {

        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");

        System.out.println(list.size());

        /*
         * sorting & filtering
         */

//        Collections.sort(list, (x, y) -> x.getParkName().length() - y.getParkName().length());  // ParkName 글자 수로 sorting
//
//        list.forEach(x -> System.out.println(x));
//        System.out.println(list.size());
//
//        System.out.println();
//        System.out.println("-------------------------구분선------------------------------------------------");
//        System.out.println();
//
//        list.removeIf(x -> !x.getCountry().equals("US"));    // 국가가 US이면 참, boolean값 return, 참을 return하는 값은 자동 제거
//                                                            // US가 아닌 park 제거한 결과
//        list.forEach(System.out::println);      // Method reference
//        System.out.println(list.size());



        /*
         * stream 이용
         */
//        list.stream()
//                .sorted((x, y) -> x.getParkName().length() - y.getParkName().length())
//                .filter(x -> x.getCountry().equals("US"))                               // 필터는 거짓인 것을 필터링
//                .forEach(x -> System.out.println(x));

        long us = list.stream()
                .sorted((x, y) -> x.getParkName().length() - y.getParkName().length())
                .filter(x -> x.getCountry().equals("US"))                               // 필터는 거짓인 것을 필터링
                .count();

    }
}
