import java.util.Scanner;
public class Ex5
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i, prim = 1; 
        if(n == 0 || n == 1 || n == -1) 
            prim = 0;
        for(i = 2; i <= n/2; i++)
            if(n%i == 0)
                prim = 0;
        if(prim == 0)
            System.out.printf("%d nu este prim", n);
        else 
            System.out.printf("%d este prim", n);
    }
}