package service;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Park;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkService {

    public static String resolveCountry(String code) {

        switch (code) {
            case "US":
                return "미국";
            case "CA":
                return "캐나다";
            case "JP":
                return "일본";
            case "AU":
                return "호주";
            case "PR":
                return "푸에트리코";
            case "MX":
                return "멕시코";
            default:
                return "무명국";
        }

    }

    public static List<Park> makeListFromCSV(String filename) {

        List<Park> list = new ArrayList<>();

        try {

            CSVReader reader = new CSVReader(new FileReader(filename));

            reader.readNext(); // skip the first line
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                list.add(new Park(spl[0], spl[1], spl[2], spl[3], spl[4], spl[5]));
            }

            return list;    // 예외 발생했을 때 return해주는 것 필요

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list; // 중간에 문제가 있을 때는 비어있는 리스트 return

    }// main 끝끝
}
