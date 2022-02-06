package leetcode.strings;

public class ZigZagString {
    public static void main(String[] args) {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("PAYPALISHIRING", 3));
        System.out.println(zigZagString.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        // 0,0 0,1 0,2
        // 1,0 1,1 1,2
        // 2,0 2,1 2,2

        //Convert to a 2D structure first.
        char arr[][] = new char[numRows][numRows];

//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr[i].length; j++) {
//                System.out.println("Row = " + i + "Col = " + j);
//                System.out.println(arr[i][j]);
//            }
//        }

        int row = 0;
        int col = 0;
        boolean down = true;
        // System.out.println(s.charAt(0));
        for(int i=0; i<s.length(); i++) {
            System.out.println("Row = " + row + "Col = " + col);
            arr[row][col] = s.charAt(i);

            if(down) {
                if(row <= numRows - 1) {
                    row++;
                } else {
                    down = false;
                    row--;
                    col++;
                }
            } else {
                if(row > 0) {
                    row--;
                    col++;
                } else {
                    down = true;
                    row++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    sb.append(arr[i][i]);
                }
            }
        }

        return sb.toString();
    }
}
