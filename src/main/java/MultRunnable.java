import java.util.List;

/**
 * Created by sergii on 2/5/17.
 */
public class MultRunnable implements Runnable {
    private int sum = 0;
    private int num;
    private List list;

    public void setNum(int num) {this.num = num;}

    public void setList(List list) {this.list = list;}

    public void run() {
        /*
        for (int i =0; i<num; i++){
            if ((i%2)==0 && (i%4)!=0 && (i%3)!=0){
                sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);
            }
        }*/
        for (int i =0; i<num*0.25; i++){

                sum = sum + (((Integer) list.get(i))*((Integer) list.get(i)))/(((Integer) list.get(i))+1);

        }
    }

    public int getSum(){
        return this.sum;
    }
}
