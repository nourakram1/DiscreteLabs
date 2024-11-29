import java.util.HashMap;

public class GCD_LCM_Primes {
    public static int gcd(int i, int j){
        HashMap<Integer, Integer> primeFactors_i = PrimeFactorizer.factorize(i);
        HashMap<Integer, Integer> primeFactors_j = PrimeFactorizer.factorize(j);
        HashMap<Integer, Integer> gcdFactors = new HashMap<>();

        for (HashMap.Entry<Integer, Integer> entry : primeFactors_i.entrySet()) {
            int factor = entry.getKey();
            if(primeFactors_j.containsKey(factor)){
                gcdFactors.put(factor, Math.min(entry.getValue(), primeFactors_j.get(factor)));
            }
        }

        int gcd = 1;
        for (HashMap.Entry<Integer, Integer> entry : gcdFactors.entrySet()) {
            gcd *= (int) Math.pow(entry.getKey(), entry.getValue());
        }

        return gcd;
    }

    public static int lcm(int i, int j){
        HashMap<Integer, Integer> primeFactors_i = PrimeFactorizer.factorize(i);
        HashMap<Integer, Integer> primeFactors_j = PrimeFactorizer.factorize(j);
        HashMap<Integer, Integer> lcmFactors = new HashMap<>();

        for (HashMap.Entry<Integer, Integer> entry : primeFactors_i.entrySet()) {
            int factor = entry.getKey();
            lcmFactors.put(factor, entry.getValue());
        }

        for (HashMap.Entry<Integer, Integer> entry : primeFactors_j.entrySet()) {
            int prime = entry.getKey();
            lcmFactors.put(prime, Math.max(lcmFactors.getOrDefault(prime, 0), entry.getValue()));
        }

        int lcm = 1;
        for (HashMap.Entry<Integer, Integer> entry : lcmFactors.entrySet()) {
            lcm *= (int) Math.pow(entry.getKey(), entry.getValue());
        }
        return lcm;
    }
}
