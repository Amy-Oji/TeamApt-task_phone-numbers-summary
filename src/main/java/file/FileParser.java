package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileParser {

// the groupByStartingCode groupd the phone by their starting codes.
// It reads the phone numbers from a file
// into a map that takes the first four figures(starting code) of the phone numbers as keys,
// and the count of each group of numbers with similar starting code as values, then returns the map.
    public Map<String, Long> groupByStartingCode(final Path path) {
        Map<String, Long> temp = null;
        try(BufferedReader br = Files.newBufferedReader(path)){
            temp =  br.lines().collect(Collectors.groupingBy(x -> x.substring(0, 4), Collectors.counting()));

        }catch (IOException e){
            e.printStackTrace();
        }
        return temp;
    }
//    the trueStatistics method returns the total number of phone numbers of each service providers.
//    it  takes a map(temp) and a string(that is assigned all the prefixes of one service provider as a single word) as parameters,
//    it loops through the map and checks if the key matches with a part of the string (the service provider prefixes)
//    if it does, it assigns the value of the map to the count... then it returns count.
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
