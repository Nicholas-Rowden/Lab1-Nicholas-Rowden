package ChangeMaker;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    private Map<Denomination, Integer> cash; // A map to store the denominations and their quantities

    public Purse() {
        cash = new HashMap<>(); // Initialize the map
    }

    public void add(Denomination type, int num) {
        // Add the given number of a specific denomination to the purse
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        // Remove the given number of a specific denomination from the purse if available
        if (cash.containsKey(type) && cash.get(type) >= num) {
            cash.put(type, cash.get(type) - num);
            if (cash.get(type) == 0) {
                cash.remove(type); // Remove the denomination from the map if its quantity is zero
            }
            return num * type.amt(); // Return the total value of the removed denominations
        }
        return 0; // Return 0 if the removal was not possible
    }

    public double getValue() {
        // Calculate the total value of all the cash in the purse
        return cash.entrySet().stream()
                .mapToDouble(e -> e.getKey().amt() * e.getValue())
                .sum();
    }

    /**
     * This method returns the current cash in the purse as a map.
     * A map is a collection of key-value pairs. In this case, the keys are
     * different denominations (types of money), and the values are the number
     * of each denomination in the purse.
     *
     * @return a map where the keys are denominations and the values are the number of each denomination in the purse
     */
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    /**
     * This method returns a string representation of the purse's contents.
     * A string is a sequence of characters. This method builds a string that
     * shows what is currently in the purse.
     *
     * @return a string showing the count and denomination of each type of cash in the purse
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n"); // Create a new string builder to build the output string
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) { // Iterate through each entry in the cash map
            sb.append(entry.getValue()).append(" x ").append(entry.getKey().name()) // Append the count and denomination name to the string
                    .append(" (").append(entry.getKey().form()).append(")\n"); // Append the form of the denomination (like coin or bill) to the string
        }
        return sb.toString(); // Return the built string
    }
}
