package SortArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Posortować liczby od najmniejszej do największej, jeżeli liczby się nie powtarzają w array to muszą być pierwsze np
// Jeżeli wejściowa lista to [4,3,5,6,3,5] to wyjściowa powinna wyglądać tak: [4,6,3,3,5,5]

public class SortArray {

    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(3);
        items.add(5);
        items.add(3);
        items.add(8);
        items.add(2);
        items.add(0);
        items.add(4);
        items.add(0);
        items.add(7);

        items.sort(Comparator.naturalOrder());
        System.out.println(items);
        System.out.println(sort(items));
    }

    public static List<Integer> sort(List<Integer> items) {
        items.sort(Comparator.naturalOrder());
        List<Integer> singleList = new ArrayList<>();
        for (int a : items) {
            List<Integer> fantom = new ArrayList<>();
            int count = 0;
            fantom.addAll(items);
            fantom.remove(items.indexOf(a));
            while (fantom.contains(a)) {
                count++;
                fantom.remove(items.indexOf(a));
            }
            if (count == 0) {
                singleList.add(a);
            }
        }
        items.removeAll(singleList);
        singleList.sort(Comparator.naturalOrder());
        items.addAll(0, singleList);
        return items;
    }

}
