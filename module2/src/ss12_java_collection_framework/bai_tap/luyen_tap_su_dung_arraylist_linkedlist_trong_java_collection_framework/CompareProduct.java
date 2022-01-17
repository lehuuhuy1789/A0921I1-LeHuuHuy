package ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection_framework;

import java.util.Comparator;

public class CompareProduct implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
//        if (o1.getName().compareTo(o2.getName())==0) {
        return (int) (o1.getPrice()-o2.getPrice());
//        }
//        return o1.getName().compareTo(o2.getName());
    }
}
