import java.util.Scanner;
public class Ex6
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 1, y = 1; 
        if(n == 1) 
            System.out.printf("%d", x);
        else if(n == 2)
                System.out.printf("%d", y);
             else {
                 int i = 2, z = 0;
                 while(i != n) {
                     z = x + y;
                     x = y;
                     y = z;
                     i = i + 1;
                 }
                 System.out.printf("%d", y);
        }
    }
}