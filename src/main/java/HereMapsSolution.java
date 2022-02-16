public class HereMapsSolution {

        public static void main(String[] args) {
            System.out.println("Hello World "  + compress("aaaabbbrrassstyyy"));
            System.out.println("Hello World "  + compress("aaaabbbrrasssty"));
            System.out.println("Hello World "  + compress("abbrrasssty"));

        }

        //input aaaabbbrrassstyyy
        //output a4b3r2as3ty3

        public static String compress(String input){
            StringBuilder sb = new StringBuilder();

            int count = 0;
            char c = input.charAt(0);
            for(int i=0; i<input.length(); i++) {
                if(i != 0 && input.charAt(i) != input.charAt(i-1)) {
                    if(count == 1) {
                        sb.append(c);
                    } else {
                        sb.append(c + "" + count);
                    }
                    count = 1;
                    c = input.charAt(i);
                } else {
                    count++;
                }
            }

            if(count > 1) {
                sb.append(c + "" + count);
            } else {
                sb.append(c + "");
            }

            return sb.toString();
        }

        //5 million to 50 million 24 hours
        //Unable to process in 24 hours.

        /** 1. Initially same machine with multithreading.
                5 million  -> 50 million.
                10 million -> 60%.
                IO operation -> wait -> multiple threads can wait.
                Increase machines -> Load Balancer.


        */

}
