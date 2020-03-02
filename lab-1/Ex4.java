import java.util.Scanner;
public class Ex4
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1, p = 1;
        while(i <= n) {
            p = p * i;
            i = i + 1;
        }
        System.out.println(p);
    }
}
