package leetcode.strings;

import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {

        /*
            Start  = /
            Separator =  /
            // = /
            ... = dirname
            path end != /
            path dont  contain . ..
        */

        // if(path.startsWith("/..")) {
        //     return "/";
        // }

//         path = path.replaceAll("/\\./", "//");
//         System.out.println("path == " + path);

//         if(path.endsWith("/.")) {
//             System.out.println("path inside == " + path);
//             path = path.substring(0, path.length() - 2);
//         }
//         System.out.println("path == " + path);

        // path = path.replaceAll("/(/)+", "/");
        // if(path.endsWith("/")) {
        //     path = path.substring(0, path.length() - 1);
        // }

        // StringBuilder pathOut = new StringBuilder();

        String[] split = path.split("/");
        LinkedList<String> ll = new LinkedList<>();

        for(int i=1; i<split.length; i++) {
            if(split[i].equals("..")) {
                if(ll.size() > 0) {
                    ll.removeLast();
                }
            } else if(split[i].equals(".") || split[i].length()==0) {
                continue;
            } else {
                ll.addLast(split[i]);
            }
        }

        if(ll.size() == 0) {
            return "/";
        }

        String pathOut = "";
        for(String l: ll) {
            pathOut = pathOut + "/" + l;
        }
        System.out.println("path == " + pathOut);
        System.out.println("----------------");
        return pathOut;
    }
}
