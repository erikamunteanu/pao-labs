import java.util.Scanner;
public class Ex2
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(a!=b) {
            System.out.printf("%d != %d\n", a, b);
        }
        if(a==b) {
            System.out.printf("%d == %d\n", a, b);
        }
        if(a<=b) {
            System.out.printf("%d <= %d\n", a, b);
        }
        if(a<b) {
            System.out.printf("%d < %d\n", a, b);
        }
        if(a>=b) {
            System.out.printf("%d >= %d\n", a, b);
        }
        if(a>b) {
            System.out.printf("%d > %d\n", a, b);
        }
    }
}
