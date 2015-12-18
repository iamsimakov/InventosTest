import java.util.Locale;
import java.util.Scanner;
import static java.lang.Math.*;

public class Titanik {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String[] mas = new String[9];
        int k = 0;
        while (in.hasNext()){
            String str = in.nextLine();
            mas[k] = str;
            if (str.replaceAll("\\s", "").equals("===")) break;
            k++;
        }

        int correctionLatitude = 1;
        if (!mas[3].substring(mas[3].length()-3).equals(mas[6].substring(mas[6].length()-3))) correctionLatitude = -1;
        int correctionLongitude = 1;
        if (!mas[4].substring(mas[4].length()-3).equals(mas[7].substring(mas[7].length()-3))) correctionLongitude = -1;

        String[] shipLatitude = mas[3].split("\\D");
        String[] shipLongitude = mas[4].replace("and ", "").split("\\D");
        String[] iceLatitude = mas[6].split("\\D");
        String[] iceLongitude = mas[7].replace("and ", "").split("\\D");

        double shipLatitudeDegree = (Double.parseDouble(shipLatitude[0]) +
                Double.parseDouble(shipLatitude[1]) / 60.0 + Double.parseDouble(shipLatitude[2]) / 3600.0)*Math.PI/180;
        double shipLongitudeDegree = (Double.parseDouble(shipLongitude[0]) +
                Double.parseDouble(shipLongitude[1]) / 60.0 + Double.parseDouble(shipLongitude[2]) / 3600.0)*Math.PI/180;
        double iceLatitudeDegree = (Double.parseDouble(iceLatitude[0]) +
                Double.parseDouble(iceLatitude[1]) / 60.0 + Double.parseDouble(iceLatitude[2]) / 3600.0)*Math.PI/180;
        double iceLongitudeDegree = (Double.parseDouble(iceLongitude[0]) +
                Double.parseDouble(iceLongitude[1]) / 60.0 + Double.parseDouble(iceLongitude[2]) / 3600.0)*Math.PI/180;

        double d = acos( sin(shipLatitudeDegree)*sin(iceLatitudeDegree*correctionLatitude) + cos(shipLatitudeDegree)*cos(iceLatitudeDegree*correctionLatitude)
                * cos(shipLongitudeDegree - iceLongitudeDegree*correctionLongitude));

        double r = 6875.0 / 2.0;
        double route = d * r;

        System.out.printf(Locale.ENGLISH, "The distance to the iceberg: %.2f miles.\n", route);
        if (100.00 - route > 0.005) System.out.println("DANGER!"); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}
