package binance;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(Set.of(
                "glass", "wine", "bottle", "wines", "neck", "neckstar", "bottleneck", "bottlenecks"));
        Set<String> stringSet2 = new HashSet<>(Set.of(
                "glass", "wine", "bottle", "wines", "neck", "neckstar", "bottleneck", "bottlenecks"));

        System.out.println(isBreakable("glasswinebottlewinesneckneckstarbottleneckbottlenecks", stringSet, stringSet.stream().findFirst().get()));
        System.out.println(isBreakable("glasswinebottlewinesneckneckstarbottleneckbottleneks", stringSet2, stringSet2.stream().findFirst().get()));
    }

    public static boolean isBreakable(String s, Set<String> dict, String word) {
        if(dict.isEmpty()) {
            return true;
        } else {
            List<String> superStrings = containsInList(word, dict);
//            System.out.println(superStrings);
            if(superStrings.size() == 0) {
                //Remove from the main string.
                Pair<String, Boolean> status = remove(s, word);
                s = status.getStatus();
                if(status.getValue()) {
                    dict.remove(word);
                    if(dict.isEmpty())
                        return true;
                    return isBreakable(s, dict, dict.stream().findFirst().get());
                }
                return false;
            } else {
                //Words with the largest string will be removed first.
                // Sort the superStrings in that order.
                superStrings.sort(Comparator.comparing(String::length).reversed());
                for (String ssr: superStrings) {
                    boolean status = isBreakable(s, dict, ssr);
                    if(!status) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private static Pair<String, Boolean> remove(String s, String word) {
        String s1 = s.replaceFirst(word, "");
        if(s1.length() == s.length()) {
            System.out.println("Word " + word + " is not a substring of " + s);
            return new Pair<String, Boolean>(s1, false);
        }
        return new Pair<>(s1, true);
    }

    private static List<String> containsInList(String word, Set<String> dict) {
        List<String> contains = new ArrayList<>();
        for (String s: dict) {
            if(s.contains(word) && !s.equals(word)) {
                contains.add(s);
            }
        }
        return contains;
    }

    private static class Pair<T1, T2> {
        T1 status;
        T2 value;

        public Pair(T1 status, T2 value) {
            this.status = status;
            this.value = value;
        }

        public T1 getStatus() {
            return status;
        }

        public T2 getValue() {
            return value;
        }
    }
}
