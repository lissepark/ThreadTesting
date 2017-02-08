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
        Thread t1;
        Thread t2;
        Thread t3;
        Thread t4;
        MultRunnable thr1 = new MultRunnable();
        MultRunnable2 thr2 = new MultRunnable2();
        MultRunnable3 thr3 = new MultRunnable3();
        MultRunnable4 thr4 = new MultRunnable4();
        Random rand = new Random();
        int l = 7;
        int k = 1;
        int sum = 0;

        OutputStream os = null;
        try {
            os = new FileOutputStream("/home/sergii/Documents/charres7.txt");
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
            sum = 0;
            for (int i = 0; i < k; i++) {
                calc.add(rand.nextInt(100));
            }


            long startTime = System.nanoTime()/1000;

            //thr1 = new MultRunnable(k,calc);
            //thr2 = new MultRunnable2(k,calc);
            thr1.setNum(k);
            thr1.setList(calc);
            thr2.setNum(k);
            thr2.setList(calc);
            thr3.setNum(k);
            thr3.setList(calc);
            thr4.setNum(k);
            thr4.setList(calc);
            t1 = new Thread(thr1);
            t2 = new Thread(thr2);
            t3 = new Thread(thr3);
            t4 = new Thread(thr4);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            //while(t1.getState()== Thread.State.RUNNABLE){};
            //while(t2.getState()== Thread.State.RUNNABLE){};

                try {
                    t2.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                try {
                    t1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                try {
                    t3.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                try {
                    t4.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

/*
            for (int i = 0; i < k; i++) {
                sum = sum + (((Integer) calc.get(i))*((Integer) calc.get(i)))/(((Integer) calc.get(i))+1);
            }
*/

            sum = thr1.getSum() + thr2.getSum() + thr3.getSum() + thr4.getSum();

            long endTime = System.nanoTime()/1000;

            System.out.println(k);
            System.out.println("That took " + (endTime - startTime) + " microseconds");
            System.out.println(sum);

            try {
                w.write("Count: "+k+"; \n");
                w.write("That took " + (endTime - startTime) + " microseconds; ");
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
