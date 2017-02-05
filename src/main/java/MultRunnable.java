import java.util.List;

/**
 * Created by sergii on 2/5/17.
 */
public class MultRunnable implements Runnable {
    private int sum;
    private int num;
    private List list;

    MultRunnable(int sum, int num, List list){
        this.sum = sum;
        this.num = num;
        this.list = list;
    }

    public void run() {

    }
}
