package greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class Ejercicio1 {
    private ArrayList<Integer> conjunto;
    private int m;

    public Ejercicio1(ArrayList<Integer> conjunto, int m) {
        this.conjunto = conjunto;
        this.m = m;
    }

    public ArrayList<Integer> solucion() {
        conjunto.sort(Comparator.reverseOrder());
        int total = 0;
        ArrayList<Integer> s = new ArrayList<>();

        while (total < this.m && !conjunto.isEmpty()) {
            int x = conjunto.get(0);
            if ((total + x) <= m) {
                s.add(x);
                total += x;
            } else {
                conjunto.remove(0);
            }
        }

        if (total == m) {
            return s;
        } else {
            return null;
        }

    }
}
