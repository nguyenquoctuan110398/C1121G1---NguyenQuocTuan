package ss10_DSA_danh_sach.bai_tap.ArrayListIsMethodsByLibrary;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int deFaultCapacity = 10;
    //mang chua cac phan tu
    Object element[];

    //suc chua mac di h khi khoi tao la 10;
    public MyList() {
        element = new Object[deFaultCapacity];
    }

    public MyList(int deFaultCapacity) {
        if (deFaultCapacity >= 0) {
            element = new Object[deFaultCapacity];
        } else {
            throw new IllegalArgumentException("capacity" + deFaultCapacity);
        }
        this.deFaultCapacity = deFaultCapacity;

    }

    public int size() {
        return this.size;
    }

    public void clean() {
        size = 0;
        for (int i = 0; i < element.length; i++) {
            element[i] = null;
        }

    }

    public boolean add(E elements) {
        if(element.length == size) {
            ensureCapacity(10);
        }
        element[size] = elements;
        size++;
        return true;
    }
    public void add(E temp, int index){
        if (index>element.length){
            throw new IllegalArgumentException("index "+ index);
        }else if(element.length==size){
            ensureCapacity(10);
        }
        if (element[index]==null){
            element[index]=temp;
            size++;
        }else {
            for (int i =size+1 ; i>=index;i--){
                element[i]=element[i-1];
            }
            element[index]=temp;
            size++;
        }
    }
    //tang kich thuoc mang
    public void ensureCapacity(int minCapacity){
        if(minCapacity>=0){
            int newSize = this.element.length + minCapacity;
            element = Arrays.copyOf(element,newSize);
        }
        else {
            throw new IllegalArgumentException("minCapacity "+ minCapacity);
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) element[i];
    }
}