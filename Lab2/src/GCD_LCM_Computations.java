public class GCD_LCM_Computations {
    public static int gcd(int i, int j){
        if(j > i){
            int temp = i;
            i = j;
            j = temp;
        }
        if(j == 0) return i;
        return gcd(j, i % j);
    }

    public static int lcm(int i, int j){
        int gcd = gcd(i, j);
        return i*j/gcd;
    }
}
