import java.util.Scanner;
public class Ex7
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i, j, prim; 
        for(i = n; i >= 1; i--)
            if(n%i == 0) {
                prim = 1;
                for(j = 2; j <= i/2; j++)
                    if(i%j == 0) {
                        prim = 0;
                        break; 
                    }
                if(prim == 1) {
                    System.out.printf("%d", i);
                    break;
                }
            }
    }
}