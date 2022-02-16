import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 234
 * 32423
 * 65
 * 34234
 * 2345234
 * 2345345
 * 23459086
 * -93845
 * -9845
 */

public class Paytm2 {
    private Path generateInputFile() throws IOException {
        Random random = new Random();
        Path numbers = Files.createTempFile("numbers", ".txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(numbers)) {
            for (int i = 0; i < 100_000; i++) {
                bufferedWriter.write(String.valueOf(random.nextInt()));
                bufferedWriter.newLine();
            }
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Paytm2().generateInputFile());
        //1. Process them in chunks.
        //2. For each chunk, there will be a sorted data. 16 chunks.
        //3. 2 chunks at a time for 8 chunks.
        //4. 2 chunks at a time for 4 chunks.
        //5. 2
        //6. Final output.

        File file = new File("C:\\Users\\User\\AppData\\Local\\Temp\\numbers8863702337709872791.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int chunkSize = 10000;
        int i=0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while((st = br.readLine()) != null) {
            //pw.println(st);
            list.add(Integer.parseInt(st));
            if(i == 9999) {
                i = 0;
                Collections.sort(list);
                count++;
                dumpIntoFile(count, list);
                list.clear();
            }
            i++;
        }
        if(!list.isEmpty()) {
            dumpIntoFile(count+1, list);
            list.clear();
        }

        //Merge two already sorted files at a time.

    }

    private static void dumpIntoFile(int count, List<Integer> list) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("C:\\Users\\User\\IdeaProjects\\Practice\\src\\out\\numbers_out"
                    + count + ".txt");
            for(Integer i: list) {
                pw.println(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
