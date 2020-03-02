import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0, s = 0;
        while(i <= n) {
            if(i%3 == 0 && i%5 == 0) {
                s = s + i;
            }
            i = i + 1;
        }
        System.out.println(s);
    }
    
}
