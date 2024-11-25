import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int number = input.nextInt();

        for(int i = 1; i < 50; i++)
        {
            System.out.println("_______________________");
            System.out.println(PrimeNumberChecker.isPrime(i)? i + " is prime" : i + " is not prime");
            System.out.println("prime factors of " + i + ": ");
            PrimeFactorizer.factorize(i);
            System.out.println("_______________________");

        }

        for (int i = 1; i <= 20; i++)
        {
            for(int j = 1; j <= 20; j++)
            {
                System.out.println("gcd(" + i + ", " + j + ") = " + Calculate_GCD.gcd(i, j));
                System.out.println("lcm(" + i + ", " + j + ") = " + Calculate_GCD.lcm(i, j));

            }

        }

        //input.close();
    }
}