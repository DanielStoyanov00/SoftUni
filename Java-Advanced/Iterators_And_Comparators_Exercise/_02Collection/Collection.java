package _02Collection;

import java.util.List;

public class Collection {
    private List<String> data;
    private int index;

    public Collection(List<String> data) {
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

    public void print() {
        if (this.index == -1) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.data.get(this.index));
        }
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void printAll() {
        for (String s : this.data) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
