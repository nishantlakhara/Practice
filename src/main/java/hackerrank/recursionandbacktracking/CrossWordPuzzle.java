package hackerrank.recursionandbacktracking;

import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CrossWordPuzzle {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        List<String> wordsSet = Arrays.stream(words.split(";"))
                                    .collect(Collectors.toList());

        char[][] chars = new char[10][10];
        for (int i=0; i<crossword.length; i++) {
            chars[i] = crossword[i].toCharArray();
        }
        List<Pair<int[], int[]>> pairsHor = scanLeftRight(chars);
        List<Pair<int[], int[]>> pairsVer = scanTopBottom(chars);

        System.out.println("===========");
        for (int i=0 ; i<pairsHor.size(); i++) {
            int[] startIndex = pairsHor.get(i).getKey();
            int[] endIndex = pairsHor.get(i).getValue();

            System.out.println("startIndex = " + startIndex[0] + "," + startIndex[1]);
            System.out.println("endIndex = " + endIndex[0] + "," + endIndex[1]);

        }

        System.out.println("===========");
        for (int i=0 ; i<pairsVer.size(); i++) {
            int[] startIndex = pairsVer.get(i).getKey();
            int[] endIndex = pairsVer.get(i).getValue();

            System.out.println("startIndex = " + startIndex[0] + "," + startIndex[1]);
            System.out.println("endIndex = " + endIndex[0] + "," + endIndex[1]);

        }

        return new String[] {};
    }

    private static List<Pair<int[],int[]>> scanTopBottom(char[][] crossword) {
        List<Pair<int[], int[]>> pairs = new ArrayList<>();
        for(int i=0; i<crossword.length; i++) {
            for(int j=0; j<crossword[i].length; j++) {
                if(crossword[j][i] == '+') {
                    continue;
                }

                int[] startIndex = new int[2];
                startIndex[0] = i;
                startIndex[1] = j;

                int[] endIndex = new int[2];
                endIndex[0] = i;
                endIndex[1] = j;
                while(crossword[j][i] == '-') {
                    endIndex[1] = j;
                    j++;
                }

                if(startIndex[0] == endIndex[0] && startIndex[1] == endIndex[1]) {
                    continue;
                }

                Pair<int[], int[]> pair = new Pair<>(startIndex,endIndex);
                pairs.add(pair);
            }
        }
        return pairs;
    }

    private static List<Pair<int[], int[]>> scanLeftRight(char[][] crossword) {
        List<Pair<int[], int[]>> pairs = new ArrayList<>();
        for(int i=0; i<crossword.length; i++) {
            for(int j=0; j<crossword[i].length; j++) {
                if(crossword[i][j] == '+') {
                    continue;
                }

                int[] startIndex = new int[2];
                startIndex[0] = i;
                startIndex[1] = j;

                int[] endIndex = new int[2];
                endIndex[0] = i;
                endIndex[1] = j;
                while(crossword[i][j] == '-') {
                    endIndex[1] = j;
                    j++;
                }

                if(startIndex[0] == endIndex[0] && startIndex[1] == endIndex[1]) {
                    continue;
                }

                Pair<int[], int[]> pair = new Pair<>(startIndex,endIndex);
                pairs.add(pair);
            }
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "/Users/nishantlakhara/Documents/Practice/src/out/output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
