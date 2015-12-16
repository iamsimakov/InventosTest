import java.io.*;

public class Kamni {

    private static int saveDiff;
    private static int sum;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int count = (int)in.nval;
        int[] mas = new int[count];
        for (int j=0; j < count; j++){
            in.nextToken();
            mas[j] = (int)in.nval;
        }

        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas.length; j++){
                if (mas[i] < mas[j]){
                    int a = mas[i];
                    mas[i] = mas[j];
                    mas[j] = a;
                }
            }
        }

        sum = 0;
        for (int i : mas) {
            sum += i;
        }
        saveDiff = sum;
        double sered = sum / 2.0d;
        for (int j=0; j<mas.length; j++){
            int firstHeap = mas[j];
            if ( ((double)firstHeap) > sered) {
                calcDiff(firstHeap);
                continue;
            }
            for (int k = 0; k < mas.length; k++) {
                firstHeap = mas[j];
                for (int i = k; i < mas.length; i++) {
                    if (i != j) {
                        firstHeap += mas[i];
                        if ( ((double) firstHeap) > sered) {
                            calcDiff(firstHeap, mas[i]);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(saveDiff);

    }

    public static void calcDiff(int a){
        int diff = Math.abs(a - (sum - a) );
        if (diff < saveDiff){
            saveDiff = diff;
        }
    }

    public static void calcDiff(int a, int b){
        int diffWithB = Math.abs(a - (sum - a) );
        int diffWithoutB = Math.abs( a - b - (sum - (a - b) ) );
        if (diffWithB < diffWithoutB){
            if (diffWithB < saveDiff){
                saveDiff = diffWithB;
            }
        } else {
            if (diffWithoutB < saveDiff){
                saveDiff = diffWithoutB;
            }
        }
    }

}
