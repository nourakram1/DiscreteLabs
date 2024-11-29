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
                System.out.println("Euclidean");
                System.out.println("gcd(" + i + ", " + j + ") = " + GCD_LCM_Euclidean.gcd(i, j));
                System.out.println("lcm(" + i + ", " + j + ") = " + GCD_LCM_Euclidean.lcm(i, j));
                System.out.println("By Prime Factorization");
                System.out.println("gcd(" + i + ", " + j + ") = " + GCD_LCM_Primes.gcd(i, j));
                System.out.println("lcm(" + i + ", " + j + ") = " + GCD_LCM_Primes.lcm(i, j));

            }

        }

        //input.close();
    }
}