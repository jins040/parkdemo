import model.Park;
import service.ParkService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkForCollect {

    public static void main(String[] args) {

        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");

        /*
         * City 이름을 앞의 세 글자로만 mapping + state 이름을 전부 소문자로 + country이름을 US는 미국 MX는 멕시코 등등
         */
        List<Park> resultList = list.stream()
                .skip(10)  // 처음부터 10개 Skip
                .limit(10)  // 처음 혹은 skip 다음부터 10개까지 결과 산출
                //.peek(System.out::println)
                .map(x -> {
                    x.setCity(x.getCity().substring(0,3));
                    x.setState(x.getState().toLowerCase());
                    return x;
                })
                .peek(System.out::println)
                .map(x -> {
                    x.setCountry(ParkService.resolveCountry(x.getCountry()));
                    return x;
                })
                .sorted((x, y) -> x.getCountry().compareTo(y.getCountry()))
                //.filter(x -> !x.getCountry().equals("미국"))
                //.forEach(System.out::println);
                .collect(Collectors.toList());

        resultList.forEach(System.out::println );

    }
}
