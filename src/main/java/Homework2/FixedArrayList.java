package Homework2;

import java.util.ArrayList;

public class FixedArrayList<T> extends ArrayList<T> {
    private final int fixedSize;
    public FixedArrayList(int fixedSize) {
        this.fixedSize = fixedSize;
    }

    @Override
    public boolean add(T t) {
        if (fixedSize > size()){
            super.add(t);
            return true;
        }
        return false;
    }
}
