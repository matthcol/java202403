// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Hello {
    public static void main(String[] args) {
        System.out.println("Coffee or tea break");

        // numbers
        // 1. 3 integer types: short (16), int (32), long (64)
        int nbPersons = 7;
        System.out.println("Nb persons: " + nbPersons);
        System.out.println(
                "int range: "
                + Integer.MIN_VALUE
                + " to "
                + Integer.MAX_VALUE
        );
        long distanceVoyager = 9_000_000_000_000_000_000L;
        System.out.println("Distance to Voyager: " + distanceVoyager);

        // 2 - floating numbers: float (32), double (64) IEEE754
        float price = 0.1f; // binary: 0.000110011001100110011....
        System.out.println("1, 2, 3 sweets: ");
        System.out.printf("- %.8f%n", price);
        System.out.printf("- %.8f%n", 2 * price);
        System.out.printf("- %.8f%n", 3 * price);

        // see BigDecimal, compute exactly

        // texts
        char c1 = 'A';
        char c2 = '東';
        System.out.println("Characters: " + c1 + ", " + c2);
        String city = "東京";
        System.out.println(city);

        // computation
        int q = 7 / 4;
        int r = 7 % 4;
        double d = 7.0 / 4.0; // NB: i.e 7.0 / 4 i.e. 7 / 4.0
        System.out.println(
                "Division 7/4 : "
                + "q=" + q
                + ", r=" + r
                + ", d=" + d
        );

        // nbPersons = 7
        nbPersons++; // incr 1
        ++nbPersons;
        nbPersons--;
        --nbPersons;
        nbPersons += 2;
        nbPersons -= 3;
        nbPersons *= 4;
        nbPersons /= 2;
        System.out.println("Guess how many persons ? " + nbPersons);

        // comparisons
        boolean ok = price < 2.0;
        //boolean ok2 = "azerty" < "qwerty"; // error
        boolean ok2 = "azerty".compareTo("qwerty") < 0; // ok => returns int not boolean
    }
}