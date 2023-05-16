package gui_proj;

import java.util.ArrayList;

public class Vector {
    
    ArrayList<Info> archs;

    Vector() {
        archs = new ArrayList<>();
    }

    public void printVector() {
        archs.forEach((a) -> System.out.print(a + " | "));
    }
    @Override
    public String toString() {
        String s = "";
        for(Info i: archs) {
            s += i + " | ";
        }
        return s;
    }

    public int size() {
        return archs.size();
    }
    Info get(int i) {
        return archs.get(i);
    }
    void set(int i, Info info) {
        archs.set(i,info);
    }
    void add(int c, int id) {
        archs.add(new Info(c,id));
    }
}
