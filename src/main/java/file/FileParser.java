package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileParser {


    public Map<String, Long> groupByStartingCode(final Path path) {
        Map<String, Long> temp = null;
        try(BufferedReader br = Files.newBufferedReader(path)){
            temp =  br.lines().collect(Collectors.groupingBy(x -> x.substring(0, 4), Collectors.counting()));

        }catch (IOException e){
            e.printStackTrace();
        }
        return temp;
    }

    public Long trueStatistics(final Map<String, Long> map, final String str) {
        Long count = 0L;
        for (Map.Entry<String, Long> m : map.entrySet()) {
            if (str.contains(m.getKey())) {
                System.out.println(" " + m.getKey() + ": Totals " + m.getValue() );
                count += m.getValue();
            }
        }
        return count;

    }

}
