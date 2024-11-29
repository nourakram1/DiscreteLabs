import java.util.HashMap;

public class PrimeFactorizer {

    public static HashMap<Integer, Integer> factorize(int number)
    {
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        for(int i = 2; i*i <= number; i++)
        {
            int multiplicity = 0;
            while(number % i == 0)
            {
                multiplicity++;
                number /= i;
            }
            if(multiplicity != 0)
                primeFactors.put(i, multiplicity);
        }
        if(number > 1) primeFactors.put(number, 1);

        /*for (int factor : primeFactors.keySet()) {
            int multiplicity = primeFactors.get(factor);
            System.out.println(factor + " -> " + multiplicity);
        }*/
        return primeFactors;
    }
}
