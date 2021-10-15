package _04Froggy;


import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    public int[] stonesNumbers;

    public Lake(int[] stonesNumbers){
        this.stonesNumbers = stonesNumbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int lastEvenIndex = stonesNumbers.length % 2 == 0
                    ? stonesNumbers.length - 2
                    : stonesNumbers.length - 1;
            @Override
            public boolean hasNext() {
                return this.index < stonesNumbers.length;
            }

            @Override
            public Integer next() {
                if (this.index == lastEvenIndex){
                    int element = stonesNumbers[lastEvenIndex];
                    this.index = 1;
                    return element;
                }
                int element = stonesNumbers[this.index];
                this.index += 2;
                return element;
            }
        };
    }
}
