package salary.service;

import com.opencsv.CSVReader;
import salary.model.Salaries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalaryService {

    public static List<Salaries> makeListFromCSV(String fileName) {

        List<Salaries> list = new ArrayList<>();

        try {

            CSVReader reader = new CSVReader(new FileReader(fileName));

            reader.readNext();
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                LocalDate localdate = LocalDate.of(Integer.parseInt(spl[0]), 1, 1);
                list.add(new Salaries(localdate, spl[1], spl[2], spl[3], Integer.parseInt(spl[4])));
            }

            return list;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }
}
