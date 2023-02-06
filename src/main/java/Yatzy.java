import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.Comparator.reverseOrder;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.Arrays.asList;


public class Yatzy {

    private static Stream<Integer> filterNumberByFrequency(IntStream dice, int targetNumber)
    {
        Map<Integer, Long> frequency = dice.boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return  frequency.entrySet().stream()
                .filter(e -> e.getValue() >= targetNumber)
                .map(Entry::getKey);

    }

    public static int CalculOnesToSixes(IntStream dice, int targetNumber) {
        return (int) dice.filter(die -> die == targetNumber).count() * targetNumber;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        boolean allSame = IntStream.of(d1, d2, d3, d4, d5).distinct().count() == 1;
        return allSame ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {

        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 1);

    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 3);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5)
    {
        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 4);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5)
    {
        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 5);

    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5)
    {
        return CalculOnesToSixes(IntStream.of(d1, d2, d3, d4, d5), 6);
    }



    public static int pair(int d1, int d2, int d3, int d4, int d5)
    {
        List<Integer> pairs = filterNumberByFrequency(IntStream.of(d1, d2, d3, d4, d5), 2)
                .sorted(reverseOrder())
                .collect(toList());

        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;

    }


    public static int twoPairs(int d1, int d2, int d3, int d4, int d5)
    {
        List<Integer> pairs = filterNumberByFrequency(IntStream.of(d1, d2, d3, d4, d5), 2)
                .sorted(reverseOrder())
                .collect(toList());

        return pairs.size() >= 2 ? pairs.stream().mapToInt(pair -> pair * 2).sum()  : 0 ;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        return filterNumberByFrequency(IntStream.of(d1, d2, d3, d4, d5), 3)
                .findFirst()
                .orElse(0) * 3;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> frequency = IntStream.of(d1, d2, d3, d4, d5)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return frequency.entrySet().stream()
                .filter(e -> e.getValue() >= 4)
                .map(Entry::getKey)
                .findFirst()
                .orElse(0) * 4;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        boolean bool  = asList(d1, d2, d3, d4, d5)
            .stream()
            .sorted()
            .collect(toList())
            .equals(asList(1, 2, 3, 4, 5));

        return bool ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        boolean bool  = asList(d1, d2, d3, d4, d5)
                .stream()
                .sorted()
                .collect(toList())
                .equals(asList(2,3,4,5,6));

        return bool ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        boolean bool =  (pair(d1, d2, d3, d4, d5) != 0) && (threeOfAKind(d1, d2, d3, d4, d5) != 0) && (yatzy(d1, d2, d3, d4, d5) == 0);
        return bool ? asList(d1, d2, d3, d4, d5).stream().mapToInt(Integer::intValue).sum() : 0;

    }
}
