import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Universe (comma-separated strings): ");
            String[] universeArray = scanner.nextLine().replaceAll(" ", "").split(",");
            ArrayList<String> universe = new ArrayList<>(List.of(universeArray));

            System.out.println("Enter the number of sets: ");
            int numSets;
            while (true) {
                try {
                    numSets = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter the number of sets: ");
                    scanner.nextLine();
                }
            }
            List<BitSet> sets = new ArrayList<>();
            scanner.nextLine();
            for (int i = 0; i < numSets; i++) {
                System.out.println("Enter elements of Set " + (i + 1) + " (comma-separated strings): ");
                String[] elements = scanner.nextLine().replaceAll(" ", "").split(",");
                BitSet set = new BitSet(universe);
                for (String element : elements) {
                    element = element.trim();
                    if (!element.isEmpty()) {
                        try {
                            set.addString(element);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Empty string detected, skipping.");
                    }
                }
                sets.add(set);
            }

            while (true) {
                System.out.println("\nSelect an operation:");
                System.out.println("1) Union of two sets");
                System.out.println("2) Intersection of two sets");
                System.out.println("3) Complement of a set");
                System.out.println("4) Difference between two sets");
                System.out.println("5) Cardinality of a set");
                System.out.println("6) Print a set");
                System.out.println("7) Exit");

                int choice;
                while (true) {
                    try {
                        choice = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a valid operation number (1-7): ");
                        scanner.nextLine();
                    }
                }
                if (choice == 7) break;

                try {
                    switch (choice) {
                        case 1: // Union
                            System.out.println("Enter indices of the two sets to union (1-based): ");
                            int u1 = getValidIndex(scanner, sets.size()) - 1;
                            int u2 = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Union: " + sets.get(u1).union(sets.get(u2)).getElements());
                            break;

                        case 2: // Intersection
                            System.out.println("Enter indices of the two sets to intersect (1-based): ");
                            int i1 = getValidIndex(scanner, sets.size()) - 1;
                            int i2 = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Intersection: " + sets.get(i1).intersect(sets.get(i2)).getElements());
                            break;

                        case 3: // Complement
                            System.out.println("Enter index of the set to complement (1-based): ");
                            int c1 = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Complement: " + sets.get(c1).complement().getElements());
                            break;

                        case 4: // Difference
                            System.out.println("Enter indices of the two sets to find difference (Set1 - Set2, 1-based): ");
                            int d1 = getValidIndex(scanner, sets.size()) - 1;
                            int d2 = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Difference: " + sets.get(d1).difference(sets.get(d2)).getElements());
                            break;

                        case 5: // Cardinality
                            System.out.println("Enter index of the set to find cardinality (1-based): ");
                            int car = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Cardinality: " + sets.get(car).cardinality());
                            break;

                        case 6: // Print a set
                            System.out.println("Enter index of the set to print (1-based): ");
                            int p1 = getValidIndex(scanner, sets.size()) - 1;
                            System.out.println("Set: " + sets.get(p1).getElements());
                            break;

                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getValidIndex(Scanner scanner, int maxSize) {
        while (true) {
            try {
                int index = scanner.nextInt();
                if (index >= 1 && index <= maxSize) return index;
                System.out.println("Invalid index! Enter a number between 1 and " + maxSize + ".");
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

}