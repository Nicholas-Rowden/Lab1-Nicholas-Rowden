package ChangeMaker;

/**
 * The Register class simulates a cash register that can provide change.
 */
public class Register {
    // Define an array of Denomination objects representing different types of money
    private static final Denomination[] DENOMINATIONS = {
            new Denomination("Hundred Note", 100.0, "bill", "one-hundred-note.png"),
            new Denomination("Fifty Note", 50.0, "bill", "fifty-note.png"),
            new Denomination("Twenty Note", 20.0, "bill", "twenty-note.png"),
            new Denomination("Ten Note", 10.0, "bill", "ten-note.png"),
            new Denomination("Five Note", 5.0, "bill", "five-note.png"),
            new Denomination("Dollar Note", 1.0, "bill", "one-note.png"),
            new Denomination("Quarter", 0.25, "coin", "quarter.png"),
            new Denomination("Dime", 0.10, "coin", "dime.png"),
            new Denomination("Nickel", 0.05, "coin", "nickel.png"),
            new Denomination("Penny", 0.01, "coin", "penny.png")
    };

    /**
     * This method creates a Purse object containing the denominations that make up the given amount.
     *
     * @param amt the amount of money for which change is to be made
     * @return a Purse object containing the appropriate denominations
     */
    public Purse makeChange(double amt) {
        Purse purse = new Purse(); // Create a new Purse object
        for (Denomination denomination : DENOMINATIONS) { // Iterate over each denomination
            int count = (int) (amt / denomination.amt()); // Calculate how many of this denomination are needed
            if (count > 0) {
                purse.add(denomination, count); // Add the denomination to the purse
                amt -= count * denomination.amt(); // Subtract the value of the added denominations from the total amount
            }
        }
        return purse; // Return the purse containing the change
    }

    /**
     * The main method to test the Register class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Register register = new Register(); // Create a new Register object
        Purse purse = register.makeChange(187.36); // Make change for $187.36
        System.out.println(purse); // Print the contents of the purse
    }
}
