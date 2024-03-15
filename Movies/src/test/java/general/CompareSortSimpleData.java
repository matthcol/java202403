package general;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompareSortSimpleData {

    @Test
    void demoCompareSortIntegers(){
        int[] numbers = {654, 123, 789, 987, 321, 456};
        System.out.println(Arrays.toString(numbers));
        boolean cmp = numbers[0] < numbers[1];
        System.out.println(cmp);
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(numberList);
        Collections.shuffle(numberList);
        System.out.println(numberList);
        Collections.sort(numberList);
        System.out.println(numberList);

        Collections.shuffle(numberList);
        SortedSet<Integer> numberSet = new TreeSet<>(numberList);
        System.out.println(numberSet);
        numberSet.add(666);
        System.out.println(numberSet);
        numberSet.add(666);
        System.out.println(numberSet);

        IntStream.range(0, 10)
                .forEach(i -> numberList.add(666));
        System.out.println(numberList);

        numberList.sort(Comparator.reverseOrder());
        System.out.println(numberList);
    }

    @Test
    void demoCompareSortText(){
        List<String> cities = new ArrayList<>();
        Collections.addAll(cities, "Toulouse", "Montauban", "Pau", "Bordeaux");
        System.out.println(cities);
        Collections.sort(cities); // String::compareTo
        System.out.println(cities);
        Collections.sort(cities, Comparator.reverseOrder());
        System.out.println(cities);

        cities.add("bayonne");
        Collections.sort(cities);  // ! bayonne at the end
        System.out.println(cities);

        Collections.sort(cities, String::compareToIgnoreCase);
        Collections.sort(cities, (c1, c2) -> c1.compareToIgnoreCase(c2));  // equivalent preceding
        System.out.println(cities);

        cities.add("Angoulême");
        cities.add("Angoulins");
        cities.add("Étretat");
        cities.add("Aÿ");
        cities.add("Azay-le-Rideau");
        Collections.sort(cities, String::compareToIgnoreCase);
        System.out.println(cities);

        // how to sort in French ?
        Collections.sort(cities, Collator.getInstance()); // if default locale set to fr_FR
        System.out.println(cities);
        Collections.sort(cities, Collator.getInstance(Locale.of("fr", "FR")));
        System.out.println(cities);

        Comparator<? super String> cmp = Collator.getInstance();
        Collections.sort(cities, cmp.reversed());
        System.out.println(cities);
    }

    @Test
    void sortEs(){
        // sort spanish words:
        var localeEs = Locale.of("es","ES");
        var collatorEs = Collator.getInstance(localeEs);
        var defaultCollator = Collator.getInstance();
        var data = List.of("mano", "mañana", "matador");
        data.stream()
                .sorted(collatorEs)
                .forEach(System.out::println);
        System.out.println();
        data.stream()
                .sorted(defaultCollator)
                .forEach(System.out::println);
        System.out.println();
        data.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void demoAvailableLocales(){
        Locale.availableLocales()
                .map(Locale::toString)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void demoGetSetLocale(){
        var locale = Locale.getDefault();
        System.out.println(locale);
        var localeEs = Locale.of("es", "ES");
        System.out.println(localeEs);
        var localeFr = Locale.of("fr", "FR");
        System.out.println(localeFr);
        var localeFrBis = Locale.FRENCH;
        System.out.println(localeFrBis);
        var localeUS = Locale.of("en", "US");
        System.out.println(localeUS);
        System.out.println();
        Stream.of(locale, localeEs, localeFr, localeUS)
                .forEach(l -> {
                    System.out.println(l);
                    System.out.println(String.format(l, "%.2f", Math.PI));
                    System.out.println(NumberFormat.getCurrencyInstance(l).format(3.14));
                    System.out.println();
                });
    }
}
