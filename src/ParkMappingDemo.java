import model.Park;
import service.ParkService;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkMappingDemo {

    public static void main(String[] args) {

        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");

        /*
         * Alias가 없는 칸에는 "없음"을 추가한 mapping
         */
        // mapping은 전체 data 수는 같지만 그 안의 내용만 바뀌는 것

//        list.stream()
//                .map(x -> {
//                    String alias = x.getParkAlias();
//                    if (alias == null || alias.equals("")) {
//                        alias = "없음";
//                    }
//                    x.setParkAlias(alias);
//                    return x;
//                })
//                .forEach(x -> System.out.println(x));


        /*
         * City 이름 첫 번째 글자를 소문자로 바꿔서 출력한 예제
         */

//       list.stream()
//                .map(x ->{
//                    String str = x.getCity().substring(0,1).toLowerCase();
//                    x.setCity(str + x.getCity().substring(1));
//                    return x;
//                })
//                .forEach(x -> System.out.println(x));

        /*
         * City 이름을 앞의 세 글자로만 mapping + state 이름을 전부 소문자로 + country이름을 US는 미국 MX는 멕시코 등등
         */
//        long count = list.stream()
//                .skip(10)  // 처음부터 10개 Skip
//                .limit(10)  // 처음 혹은 skip 다음부터 10개까지 결과 산출
//                //.peek(System.out::println)
//                .map(x -> {
//                    x.setCity(x.getCity().substring(0,3));
//                    x.setState(x.getState().toLowerCase());
//                    return x;
//                })
//                .peek(System.out::println)
//                .map(x -> {
//                    x.setCountry(ParkService.resolveCountry(x.getCountry()));
//                    return x;
//                })
//                .sorted((x, y) -> x.getCountry().compareTo(y.getCountry()))
//                //.filter(x -> !x.getCountry().equals("미국"))
//                //.forEach(System.out::println);
//                .count();

        /*
         * Park 이름을 Int 형으로 (park name 이름 글자 수)
         */
        OptionalDouble result = list.stream()
                .mapToInt(x -> x.getParkName().length())
                .peek(System.out::println)
                .average();                 // Stream()이 비어있으면 연산불가를 return, null일 수도 아닐수도 (for Optional)

        if (result.isPresent()) {
            System.out.println(result.getAsDouble());
        } else {
            System.out.println("값이 없습니다.");
        }

        System.out.println(result);

//        list.stream()
//                .map(x -> x.getParkName().length())
//                .forEach(System.out::println);

    }
}
