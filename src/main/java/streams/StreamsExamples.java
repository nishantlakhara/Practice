package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsExamples {

    public static void main(String[] args) {
        getFirstNonRepeatingCharacter();
    }

    public static void getFirstNonRepeatingCharacter() {
        String str = "swiss";

        Map<Character, Long> map =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()));

        Character ch = map.entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(map);
        System.out.println(ch);
    }
}
