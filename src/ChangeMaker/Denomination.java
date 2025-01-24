package ChangeMaker;

/**
 * A record class to represent a denomination of money.
 * A record is a special kind of class in Java that is used to model
 * immutable data. It automatically generates the constructor,
 * getter methods, equals(), hashCode(), and toString() methods.
 *
 * @param name the name of the denomination (e.g., "Quarter", "Dollar")
 * @param amt the monetary value of the denomination (e.g., 0.25, 1.00)
 * @param form the form of the denomination (e.g., "coin", "bill")
 * @param img the image file name representing the denomination
 */
public record Denomination(String name, double amt, String form, String img) {}
