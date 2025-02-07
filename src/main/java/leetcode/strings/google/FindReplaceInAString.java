package leetcode.strings.google;

import org.apache.commons.codec.BinaryDecoder;

public class FindReplaceInAString {

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = new int[] {0,2};
        String[] sources = new String[] {"a", "cd"};
        String[] targets = new String[] {"eee", "ffff"};

        String out = new FindReplaceInAString().findReplaceString(s, indices, sources, targets);
        System.out.println("out = " + out);
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        StringBuilder sb = new StringBuilder();

        // abcd -> eeebffff , a->eee, cd->ffff
        int k = 0;
        int index = indices[k];
        for(int i=0; i<s.length(); i++) {
            System.out.println(i + "\tindex=" + index);
            if(i < index) {
                sb.append(s.charAt(i));
            }

            if(i == index) {
                String src = sources[k];
                String dest = targets[k];

                sb.append(dest);
                int srcLen = src.length();
                while(srcLen-- > 1) {
                    System.out.println(i);
                    i++;
                }
                if(k < indices.length - 1)
                    index = indices[++k];
            }
        }

        return sb.toString();
    }
}
