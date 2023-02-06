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

    private static List<Integer> dice = null;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.dice = asList(d1, d2, d3, d4, d5);
    }
    private static Stream<Integer> filterNumberByFrequency(int targetNumber)
    {
        Map<Integer, Long> frequency = dice.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return  frequency.entrySet().stream()
                .filter(e -> e.getValue() >= targetNumber)
                .map(Entry::getKey);

    }

    private static int CalculOnesToSixes(int targetNumber) {
        return (int) dice.stream().filter(die -> die == targetNumber).count() * targetNumber;
    }

    public int chance()
    {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public int yatzy()
    {
        boolean allSame = dice.stream().distinct().count() == 1;
        return allSame ? 50 : 0;
    }

    public int ones() {

        return CalculOnesToSixes(1);

    }

    public int twos() {
        return CalculOnesToSixes(2);
    }

    public int threes() {
        return CalculOnesToSixes(3);
    }

    public int fours()
    {
        return CalculOnesToSixes(4);
    }

    public int fives()
    {
        return CalculOnesToSixes(5);

    }

    public int sixes()
    {
        return CalculOnesToSixes(6);
    }



    public int pair()
    {
        List<Integer> pairs = filterNumberByFrequency(2)
                .sorted(reverseOrder())
                .collect(toList());

        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;

    }


    public int twoPairs()
    {
        List<Integer> pairs = filterNumberByFrequency(2)
                .sorted(reverseOrder())
                .collect(toList());

        return pairs.size() >= 2 ? pairs.stream().mapToInt(pair -> pair * 2).sum()  : 0 ;
    }

    public int threeOfAKind()
    {
        return filterNumberByFrequency(3)
                .findFirst()
                .orElse(0) * 3;
    }

    public int fourOfAKind()
    {
        return filterNumberByFrequency(4)
                .findFirst()
                .orElse(0) * 4;
    }

    public int smallStraight()
    {
        boolean bool  = dice
            .stream()
            .sorted()
            .collect(toList())
            .equals(asList(1, 2, 3, 4, 5));

        return bool ? 15 : 0;
    }

    public int largeStraight()
    {
        boolean bool  = dice
                .stream()
                .sorted()
                .collect(toList())
                .equals(asList(2,3,4,5,6));

        return bool ? 20 : 0;
    }

    public int fullHouse()
    {
        boolean bool =  (pair() != 0) && (threeOfAKind() != 0) && (yatzy() == 0);
        return bool ? dice.stream().mapToInt(Integer::intValue).sum() : 0;

    }
}
