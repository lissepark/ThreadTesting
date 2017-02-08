import java.util.List;

/**
 * Created by sergii on 2/6/17.
 */
public class MultRunnable2 implements Runnable {
    private int sum = 0;
    private int num;
    private List list;

    public int getSum(){
        return this.sum;
    }

    public void setNum(int num) {this.num = num;}

    public void setList(List list) {this.list = list;}

    public void run() {
        /*
        for (int i =0; i<num; i++){
            if ((i%2)!=0 && (i%3)!=0){
                sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);
            }
        }*/
        for (int i = (int) (num*0.25); i<num*0.5; i++){

                sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);

        }
    }
}
