import java.util.Arrays;

public class PrimeNumberChecker {
    public static boolean isPrime(int number)
    {
        boolean[] isPrimeArray = new boolean[number+1];
        Arrays.fill(isPrimeArray, true);
        isPrimeArray[0] = isPrimeArray[1] = false;
        for(int i = 2; i <= number; i++)
        {
            if(isPrimeArray[i])
            {
                for(int j = i * 2; j <= number; j+=i)
                {
                    isPrimeArray[j] = false;
                }
            }
        }
//        for(int i = 2; i <= number; i++){
//            if(isPrimeArray[i]) System.out.println(i);
//        }
        return isPrimeArray[number];
    }
}
