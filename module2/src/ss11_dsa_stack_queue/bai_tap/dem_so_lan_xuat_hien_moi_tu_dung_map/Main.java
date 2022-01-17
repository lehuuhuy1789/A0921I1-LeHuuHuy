package ss11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_dung_map;

import java.util.*;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần đếm kí tự");
        String src = scanner.nextLine();
        src = src.toLowerCase();
        String[] arr = src.split("");
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; ++i) {
            int count = 1;
            if (treeMap.containsKey(arr[i])) {
                count += (Integer)treeMap.get(arr[i]);
            }

            if (!arr[i].equals(" ")) {
                treeMap.put(arr[i], count);
            }
        }

        Iterator var7 = treeMap.entrySet().iterator();

        while(var7.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)var7.next();
            System.out.println(entry);
        }

    }
}
