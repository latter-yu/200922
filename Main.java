import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(Number(num1, num2));
        }
    }
    public static int Number(int num1, int num2) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[3];
        for (int cur = num1; cur <= num2; cur++) {
            if ((num2 < 100000 && num1 < 100000) || (num2 >= 1000000 && num2 >= 1000000)) {
                return count;
            }
            int num = cur;
            boolean ret = false;
            while (num > 0) {
                if (!map.containsKey(num % 10)) {
                    map.put(num % 10, 1);
                } else {
                    ret = true;
                    break;
                }
                num /= 10;
            }
            if (ret == true) {
                continue;
            }
            num = cur;
            int i = 0;
            while (num > 0) {
                arr[i] = num % 100;
                num /= 100;
                i++;
            }
            if (arr[2] + arr[1] == arr[3]) {
                count++;
            }
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int strLen = sc.nextInt();
            int nameLen = sc.nextInt();
            String str =  sc.next();
            String strName = sc.next();
            int count = 1;
            int sum = 0;
            int cur = -1;
            int countSum = 0;
            char[] charStr = str.toCharArray();
            char[] charName = strName.toCharArray();
            for (int i = 0; i < nameLen; i++) {
                for (int j = cur + 1; j < strLen; j++) {
                    if (charName[i] == charStr[j]) {
                        sum += count;
                        cur = j;
                        countSum++;
                    }
                    count++;
                }
            }
            if (countSum < 3) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
                System.out.println(sum);
            }
        }
    }
}