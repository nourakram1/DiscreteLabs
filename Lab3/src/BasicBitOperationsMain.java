import java.util.Scanner;

public class BasicBitOperationsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter the number: ");
            int number = scanner.nextInt();

            System.out.print("Enter the position: ");
            int position = scanner.nextInt();

            System.out.println("Choose an operation:");
            System.out.println("1. Get bit");
            System.out.println("2. Set bit");
            System.out.println("3. Clear bit");
            System.out.println("4. Update bit");

            int operation = scanner.nextInt();
            int result = number;

            switch (operation) {
                case 1:
                    int bit = BasicBitOperations.getBit(number, position);
                    System.out.println("Bit at position " + position + ": " + bit);
                    break;

                case 2:
                    result = BasicBitOperations.setBit(number, position);
                    System.out.println("After setting bit at position " + position + ": " + result + " (Binary: " + Integer.toBinaryString(result) + ")");
                    break;

                case 3:
                    result = BasicBitOperations.clearBit(number, position);
                    System.out.println("After clearing bit at position " + position + ": " + result + " (Binary: " + Integer.toBinaryString(result) + ")");
                    break;

                case 4:
                    System.out.print("Enter the new value (true/false): ");
                    boolean value = scanner.nextBoolean();
                    result = BasicBitOperations.updateBit(number, position, value);
                    System.out.println("After updating bit at position " + position + " to " + value + ": " + result + " (Binary: " + Integer.toBinaryString(result) + ")");
                    break;

                default:
                    System.out.println("Invalid operation.");
            }

            System.out.print("Do you want to perform another operation? (1 for Yes, 0 for No): ");
            choice = scanner.nextInt();
        } while (choice == 1);

        System.out.println("Program terminated.");
        scanner.close();
    }
}
