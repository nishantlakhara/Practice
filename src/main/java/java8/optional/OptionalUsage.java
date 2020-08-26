package java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalUsage {
    public static void main(String[] args) {
        Optional<List<String>> stringListOpt = Optional.ofNullable(Arrays.asList("A", "B"));
        if(stringListOpt.isPresent()) {
            List<String> strings = stringListOpt.get();
            if(!strings.isEmpty()) {
                System.out.println(strings.get(0));
            } else {
                //List is empty
                System.out.println("List is empty " + strings);
            }
        }


    }
}
