import java.util.List;

/**
 * Created by sergii on 2/8/17.
 */
public class MultRunnable4 implements Runnable {
    private int sum = 0;
    private int num;
    private List list;

    public void setNum(int num) {this.num = num;}

    public void setList(List list) {this.list = list;}

    public void run() {
        /*
        for (int i =0; i<num; i++){
            if ((i%4)==0 && (i%3)!=0){
                sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);
            }
        }*/
        for (int i = (int) (num*0.75); i<num; i++){

            sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);

        }
    }

    public int getSum(){
        return this.sum;
    }
}
