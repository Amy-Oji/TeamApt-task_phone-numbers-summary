package file;

import java.nio.file.Path;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        String mtn_statistics = "MTN Statistics";
        String airtel_statistics = "Airtel Statistics";
        String nine_mobile_stats = "9mobile Statistics";
        String mtel_statistics = "MTEL Statistics";
        String globalCom_statistics = "GlobalCom Statistics";

//     path to the file containing the phone numbers
        Path path = Path.of("src/main/resources/PhoneNumbers.txt");

        FileParser fileParser = new FileParser();

//        calling the method that reads the file and groups it according to it's starting code
        Map<String, Long> temp = fileParser.groupByStartingCode(path);


        System.out.println();
        System.out.println();
        System.out.println("=====SUMMARY REPORT OF PHONE NUMBERS=====");
        System.out.println();
        System.out.println(mtn_statistics);
        System.out.println("====================");
        Long MTNTotal = fileParser.trueStatistics(temp, FileUtils.MTN_CODE);
        System.out.println("----------------------");
        System.out.println(" MTN Total = " + MTNTotal);
        System.out.println("----------------------");
        System.out.println();
        System.out.println();



        System.out.println(airtel_statistics);
        System.out.println("====================");
        Long airtelTotal = fileParser.trueStatistics(temp, FileUtils.AIRTEL_CODE);
        System.out.println("----------------------");
        System.out.println(" Airtel Total = " + airtelTotal);
        System.out.println("----------------------");
        System.out.println();
        System.out.println();


        System.out.println(nine_mobile_stats);
        System.out.println("====================");
        Long nmobile = fileParser.trueStatistics(temp, FileUtils.NMOBILE_CODE);
        System.out.println("----------------------");
        System.out.println(" 9Mobile Total = " + nmobile);
        System.out.println("----------------------");
        System.out.println();
        System.out.println();


        System.out.println(globalCom_statistics);
        System.out.println("====================");
        Long globacom = fileParser.trueStatistics(temp, FileUtils.GLO_CODE);
        System.out.println("----------------------");
        System.out.println(" Globacom Total = " + globacom);
        System.out.println("----------------------");
        System.out.println();
        System.out.println();


        System.out.println(mtel_statistics);
        System.out.println("====================");
        Long MTEL = fileParser.trueStatistics(temp, FileUtils.MTEL);
        System.out.println("--------------------------");
        System.out.println("MTEL Total = " + MTEL);
        System.out.println("----------------------");
        System.out.println();
        System.out.println();

    }
}