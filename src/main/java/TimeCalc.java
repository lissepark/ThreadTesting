import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergii on 2/5/17.
 */
public class TimeCalc {
    public static void main(String[] args) {
        Random rand = new Random();
        int l = 7;
        int k = 1;

        OutputStream os = null;
        try {
            os = new FileOutputStream("/home/sergii/Documents/charres.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Writer w = null;
        try {
            w = new OutputStreamWriter(os, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (int r=1; r<=l;r++) {
            List calc = new ArrayList();
            k = k*10;

            for (int i = 0; i < k; i++) {
                calc.add(rand.nextInt(100));
            }
            int sum = 0;

            long startTime = System.nanoTime();


            for (int i = 0; i < k; i++) {
                sum = sum + (Integer) calc.get(i);
            }

            long endTime = System.nanoTime();

            System.out.println(k);
            System.out.println("That took " + (endTime - startTime) + " nanoseconds");
            System.out.println(sum);

            try {
                w.write("Count: "+k+"; \n");
                w.write("That took " + (endTime - startTime) + " nanoseconds; ");
                w.write("Sum: "+sum);
                w.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
