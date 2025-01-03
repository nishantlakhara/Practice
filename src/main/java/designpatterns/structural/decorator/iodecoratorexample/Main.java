package designpatterns.structural.decorator.iodecoratorexample;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        int c;

        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(System.in));

            while((c = in.read()) != 0) {
                System.out.println((char)c);
            }
        } catch (IOException e) {

        }
    }
}
