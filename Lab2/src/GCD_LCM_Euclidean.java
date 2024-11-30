public class GCD_LCM_Euclidean {
    public static int gcd(int i, int j) throws Exception{
        if(j > i){
            int temp = i;
            i = j;
            j = temp;
        }
        if(i == 0) throw new Exception("Undefined");
        if(j == 0) return i;
        return gcd(j, i % j);
    }

    public static int lcm(int i, int j) throws Exception {
        int gcd = gcd(i, j);
        return i*j/gcd;
    }
}
