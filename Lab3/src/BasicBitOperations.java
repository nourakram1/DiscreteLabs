public class BasicBitOperations {
    public static int getBit(int number, int position){
        return (number >> position) & 1;
    }
    public static int setBit(int number, int position){
        int mask = 1 << position; return number | mask;
    }
    public static int clearBit(int number, int position){
        int mask = ~(1 << position); return number & mask;
    }
    public static int updateBit(int number, int position, boolean value){
        if(value){ return setBit(number, position);
        }
        return clearBit(number, position);
    }
}

