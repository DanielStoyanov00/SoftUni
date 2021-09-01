package _01ListIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        if (this.data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print(){
        if (this.index == -1){
            System.out.println("Invalid Operation!");
        }else {
            System.out.println(this.data.get(this.index));
        }
    }

    public boolean hasNext(){
        return this.index < this.data.size() - 1;
    }
}
