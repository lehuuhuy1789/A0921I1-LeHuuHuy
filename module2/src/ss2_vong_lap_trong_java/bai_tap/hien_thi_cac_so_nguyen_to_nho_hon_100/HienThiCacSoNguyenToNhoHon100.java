package ss2_vong_lap_trong_java.bai_tap.hien_thi_cac_so_nguyen_to_nho_hon_100;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int n = 2;

        String daySo;
        for(daySo = ""; n < 100; ++n) {
            boolean flag = true;
            if (n < 2) {
                flag = false;
            } else {
                for(int i = 2; i < n; ++i) {
                    if (n % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                daySo = daySo + n + ",";
            }
        }

        System.out.println("Dãy các số nguyên tố nhỏ hơn 100 là: " + daySo);
    }
}
