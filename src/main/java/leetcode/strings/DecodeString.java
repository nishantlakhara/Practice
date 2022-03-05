package leetcode.strings;

import java.util.LinkedList;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a2[bc11[d]]]"));
    }

    public String decodeString(String s) {
        LinkedList<Character> ll = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            //System.out.println("Char = " + s.charAt(i));
            if(s.charAt(i) == ']') {
                //Check if received ]
                StringBuilder sb = new StringBuilder();
                char c = ll.removeFirst();
                //System.out.println(c);
                while(c != '[') {
                    sb.append(c);
                    c = ll.removeFirst();
                }
                //System.out.println(sb.toString());

                //Count
                c = ll.removeFirst();
                int count = 0;
                int factor = 1;
                while(c >= '0' && c <= '9' && !ll.isEmpty()) {
                    count = count + factor*Integer.parseInt(c + "");
                    factor = factor*10;
                    c = ll.removeFirst();
                }
                if(c >= '0' && c <= '9') {
                    count = count + factor*Integer.parseInt(c + "");
                } else {
                    ll.addFirst(c);
                }

                String ss = sb.toString();
                for(int j=0; j<count; j++) {
                    for(int k=ss.length()-1; k>=0; k--) {
                        ll.addFirst(ss.charAt(k));
                    }
                }
            } else {
                //System.out.println("Push to stack = " + s.charAt(i));
                ll.addFirst(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!ll.isEmpty()) {
            sb.append(ll.removeLast());
        }

        return sb.toString();
    }
}
