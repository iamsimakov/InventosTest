import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Alex on 13.12.2015.
 */
public class Kamni {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] mas = new int[count];
        if (count >= 1 && count <= 20){
            int j = 0;
            for (String str : reader.readLine().split(" ")){
                mas[j] = Integer.parseInt(str);
                j++;
            }
            Arrays.sort(mas);
            int sum = 0;
            for (int i : mas){
                sum += i;
            }
            double seredina = sum / 2.0d;
            System.out.println(seredina);
//            for (int i = 0; i < mas.length; i++){
//
//            }
        }
    }

}
