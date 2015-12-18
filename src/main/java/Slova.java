import java.util.Scanner;

public class Slova {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int i = 0;
        while (in.hasNext() && i <= 2001){
            String str = in.nextLine();
            str = str.replaceAll("[\n\\s]+", "");
            if (!str.equals("\n") && str.length() != 0){
                if (str.length() < count){
                    str = addSymbol(str, count);
                } else if (str.length() > count){
                    str = removeSymbol(str, count);
                } else {
                    str = replaceSymbols(str, count);
                }
                System.out.println(str);
            }

            i++;
        }

    }

    public static String addSymbol(String a, int count){
        if (sum(a) % (count+1) == 0){
            a += "0";
        } else {
            for (int i = 0; i <= a.length(); i++){
                StringBuilder sb = new StringBuilder(a);
                if (sum(sb.insert(i, '0').toString()) % (count + 1) == 0) {
                    a = sb.toString();
                    break;
                } else {
                    sb.deleteCharAt(i);
                    if (sum(sb.insert(i, '1').toString()) % (count + 1) == 0 ){
                        a = sb.toString();
                        break;
                    }
                }
            }
        }
        return a;
    }

    public static int sum(String a){
        int sum = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == '1') sum += i+1;
        }
        return sum;
    }

    public static String removeSymbol(String a, int count){

        for (int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.deleteCharAt(i);
            if (sum(sb.toString()) % (count + 1) == 0) {
                a = sb.toString();
                break;
            }
        }
        return a;
    }

    public static String replaceSymbols(String a, int count){
        if (sum(a) % (count+1) == 0 ) return a;
        else{
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder(a);
                if (sb.charAt(i) == '1') {
                    sb.deleteCharAt(i);
                    sb.insert(i,'0');
                    if (sum(sb.toString()) % (count + 1) == 0) {
                        a = sb.toString();
                        break;
                    }
                }
            }
        }
        return a;
    }
}
