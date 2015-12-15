import java.io.*;
import java.util.Arrays;


public class Kamni {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int count = (int)in.nval;
        int[] mas = new int[count];
        for (int j=0; j < count; j++){
            in.nextToken();
            mas[j] = (int)in.nval;
        }
        Arrays.sort(mas);
        int sum = 0;
        for (int i : mas) {
            sum += i;
        }
        int saveDiff = sum;
        int saveHeapSum = 0;
        for (int i = 0; i < mas.length; i++) {
            int heap1Sum = mas[i];
            for (int k = 0; k < mas.length; k++) {
                int diff = Math.abs(heap1Sum - (sum - heap1Sum));
                if (diff < saveDiff) {
                    saveDiff = diff;
                    saveHeapSum = heap1Sum;
                }
                if (i == k) continue;
                heap1Sum += mas[k];
            }
        }
        System.out.println(saveDiff);
        System.out.println(saveHeapSum);
    }

}
