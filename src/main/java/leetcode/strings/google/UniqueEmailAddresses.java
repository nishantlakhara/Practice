package leetcode.strings.google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for(String email: emails) {
            String split[] = email.split("@");
            String[] split1 = split[0].split("\\+");
            unique.add(split1[0].replace(".", "") + "@" + split[1]);
        }

        return unique.size();
    }
}
