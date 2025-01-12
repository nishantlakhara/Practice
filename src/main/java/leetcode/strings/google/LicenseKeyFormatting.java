package leetcode.strings.google;

public class LicenseKeyFormatting {


    public String licenseKeyFormatting(String s, int k) {

        // if(s.length() <= k) {
        //     return s.toUpperCase();
        // }

        String[] split = s.split("-");
        System.out.println("Length = " + split.length);
        if(split.length == 0)
            return "";

        String mergedS = String.join("", split);
        int len = mergedS.length();
        int rem = mergedS.length() % k;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            System.out.println(idx);
            if(count == 0) {
                if(rem != 0) {
                    sb.append(mergedS.substring(0, rem));
                    idx += rem;
                } else {
                    sb.append(mergedS.substring(0, k));
                    idx += k;
                }
            } else {
                if(idx + k > mergedS.length()) {
                    break;
                } else {
                    sb.append("-" + mergedS.substring(idx, idx+k));
                    idx += k;
                }
            }
            count++;
        }
        //if(sb.charAt(0) == '-')
        //    sb.deleteCharAt(0);

        System.out.println("MergedS = " + mergedS);
        return sb.toString().toUpperCase();
    }
}
