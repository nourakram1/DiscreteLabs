import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int operation;
        System.out.println("Operations:\n" +
                           "1. Check Primality \n" +
                           "2. Get Prime Factorization \n" +
                           "3. Greatest Common Divisor \n" +
                           "4. Least Common Multiple");
        System.out.print("Please Select What You Want: ");
        operation = input.nextInt();

        if(operation < 1 || operation > 4) {
            do {
                System.out.print("Please Enter a Valid Operation: ");
                operation = input.nextInt();
            } while (operation < 1 || operation > 4);
        }

        switch (operation){
            case 1:
                System.out.println(PrimeNumberChecker.isPrime(readNumber(input))? "Prime Number" : "Not Prime Number");
                break;
            case 2:
                printFactors(PrimeFactorizer.factorize(readNumber(input)));
                break;
            case 3:
                printGCD(input);
                break;
            case 4:
                printLCM(input);
                break;
        }
        System.out.println("Do You Want Something (Y): ");
        if(Character.toUpperCase(input.next().charAt(0)) == 'Y'){
            main(args);
        }
        input.close();
    }

    private static void printGCD(Scanner input){
        int firstNumber = readNumber(input);
        int secondNumber = readNumber(input);
        System.out.println("Euclidean");
        try {
            System.out.println("gcd(" + firstNumber + ", " + secondNumber + ") = " + GCD_LCM_Euclidean.gcd(firstNumber, secondNumber));
        }catch (Exception e){System.out.println(e.getMessage());}
        System.out.println("By Prime Factorization");
        try {
            System.out.println("gcd(" + firstNumber + ", " + secondNumber + ") = " + GCD_LCM_Primes.gcd(firstNumber, secondNumber));
        }catch (Exception e){System.out.println(e.getMessage());}
    }

    private static void printLCM(Scanner input){
        int firstNumber = readNumber(input);
        int secondNumber = readNumber(input);
        System.out.println("Euclidean");
        try {
            System.out.println("lcm(" + firstNumber + ", " + secondNumber + ") = " + GCD_LCM_Euclidean.lcm(firstNumber, secondNumber));
        }catch (Exception e){System.out.println(e.getMessage());}
        System.out.println("By Prime Factorization");
        try {
            System.out.println("gcd(" + firstNumber + ", " + secondNumber + ") = " + GCD_LCM_Primes.gcd(firstNumber, secondNumber));
        }catch (Exception e){System.out.println(e.getMessage());}
    }

    private static void printFactors(HashMap<Integer, Integer> primeFactors){
        for (int factor : primeFactors.keySet()) {
            int multiplicity = primeFactors.get(factor);
            System.out.println("Factor " +factor + " with Multiplicity " + multiplicity);
        }
    }

    private static int readNumber(Scanner input){
        int number;
        do {
            System.out.print("Please Enter Positive Number: ");
            number = input.nextInt();
        }while (number < 1);
        return number;
    }
}