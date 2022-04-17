package com.example.gridviewwithfragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class FragmentA extends Fragment {
    ArrayList<SanPham> list = new ArrayList<SanPham>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container,false);

        fakeData();

        GridView gv_SanPham = view.findViewById(R.id.gridView_SanPham);
        MyArrayAdapter adapter = new MyArrayAdapter(getActivity(), list);
        gv_SanPham.setAdapter(adapter);

        gv_SanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                SanPham sp =  list.get(i);
                bundle.putSerializable("SanPham", sp);
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    fragmentTransaction.replace(R.id.frameContain, fragmentB);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else {
                    fragmentTransaction.replace(R.id.frameContainB, fragmentB);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                adapter.setPositionSelected(i);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public void fakeData() {
        list.add(new SanPham(1, "iPhone 13 Pro Max 256GB", 30000000, "Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ, hỗ trợ mạng 5G tốc độ cao\n" +
                "Không gian hiển thị sống động - Màn hình 6.7\" Super Retina XDR độ sáng cao, sắc nét\n" +
                "Trải nghiệm điện ảnh đỉnh cao - Cụm 3 camera 12MP, hỗ trợ ổn định hình ảnh quang học\n" +
                "Tối ưu điện năng - Sạc nhanh 20 W, đầy 50% pin trong khoảng 30 phút\n" +
                "iPhone 13 Pro Max 256GB được đánh giá là một trong những dòng iPhone có khả năng chụp ảnh siêu ấn tượng cùng với camera góc siêu rộng mang đến khả năng chụp ảnh thiếu sáng một cách đặc biệt. Không những thế, mà dòng iPhone này còn được đánh giá là có dung lượng bộ nhớ tốt, đáp ứng được đầy đủ các công việc hằng ngày\n" +
                "Xem thêm thông tin iPhone 13 Pro Max 512GB thiết kế đẳng cấp, mang lại trải nghiệm vượt trội cho người dùng", R.drawable.iphone_13_pro));

        list.add(new SanPham(2, "iPhone SE 2022", 12490000, "Hiệu năng vượt trội với vi xử lý mới nhất - Chip Apple A15 tiên tiến nhất, cân mọi tác vụ\n" +
                "Tận hưởng không gian hiển thị sắc nét - Màn hình Liquid Retina nhỏ gọn 4.7 inch tỷ lệ 16:9\n" +
                "Giải trí trọn vẹn ngày dài - Viên pin có nhiều cải tiến giúp bạn không còn lo lắng khi sử dụng\n" +
                "Camera ghi trọn mọi khoảnh khắc - Camera đơn 12 MP f/1.8 hỗ trợ công nghệ Deep Fusion\n" +
                "Thông tin mới nhất về điện thoại iPhone SE 2022\n" +
                "\n" +
                "Những thông tin mới nhất về các dòng iPhone vừa ra mắt luôn mang được sự mong chờ và nhiều sự háo hức của người hâm mộ. Có thể nói rằng chiếc iPhone SE là dòng smartphone kích thước nhỏ, mang đến sự cơ động nhưng sở hữu cấu hình mạnh mẽ. Song liệu thế hệ thứ 3 có những điểm nào nổi bật, iPhone SE 2022 có giá bao nhiêu và khi nào ra mắt? Hãy cùng chúng tôi tìm hiểu nhé!", R.drawable.iphone_se_red));


        list.add(new SanPham(3, "Samsung Galaxy Z Fold3 5G", 34190000, "Thiết kế độc đáo tiện lợi, khẳng định đẳng cấp - Thiết kế gập mở, chất liệu cao cấp, bản lề chắc chắn\n" +
                "Màn hình kép ấn tượng - Màn hình chính 7.9\" và màn hình phụ: 6.23\", 120Hz chuyển động mượt mà\n" +
                "Hệ thống camera siêu ấn tượng - Bộ 3 ống kính camera 12MP, camera selfie ẩn dưới màn hình\n" +
                "Hiệu năng ấn tượng, làm chủ tốc độ - Snapdragon 888 kết hợp RAM 12GB, hỗ trợ 5G\n" +
                "Đánh giá Samsung Galaxy Z Fold 3 (5G) - Khẳng định đẳng cấp\n" +
                "Với sự thành công đáng kinh ngạc và luôn cháy hàng từ lúc ra mắt đến thời điểm hiện tại của hai thế hệ trước là Fold 1 và Z Fold 2. Galaxy Z Fold 3 lần này được ra mắt với độ hoàn thiện cao về thiết kế và hiệu năng. Mang đến cho người dùng một trải nghiệm cực kỳ thú vị hơn.\n" +
                "\n" +
                "Thiết kế độc đáo tiện lợi, chất liệu cao cấp\n" +
                "Là sản phẩm mang đến độ hoàn thiện cao hơn nhiều so với hai phiên bản trước, điện thoại Samsung Galaxy Fold 3 được thiết kế kích thước hài hòa hơn. Giúp bạn có thể dễ dàng cầm khi đóng hoặc mở màn hình đều dễ sử dụng nhất. Bộ khớp nối bản lề mới giúp kết nối bộ khung của Galaxy Z Fold3 hoàn hảo hơn. Tăng cao độ bền khi đóng mở liên tục và cố định cực kỳ chắc chắn.", R.drawable.sm_f926_zfold3_5g_openback_phantomsilver));


        list.add(new SanPham(4, "iPhone 11 64GB",
                12650000
                , "Màu sắc phù hợp cá tính - 6 màu sắc bắt mắt để lựa chọn\n" +
                "Hiệu năng mượt mà, ổn định - Chip A13, RAM 4GB\n" +
                "Bắt trọn khung hình - Camera kép hỗ trợ góc rộng, chế độ Night Mode\n" +
                "Yên tâm sử dụng - Kháng nước, kháng bụi IP68, kính cường lực Gorilla\n" +
                "Apple luôn làm hài lòng tín đồ iFan với các dòng iPhone trong từng phân khúc giá. Đặc biệt, phiên bản iPhone 11 vừa ra mắt nhưng đã chiếm lĩnh được thị trường smartphone trên toàn thế giới với giá cả phải chăng. Cùng tìm hiểu chi tiết rõ hơn qua bài viết sau đây để có quyết định có nên mua hay không nhé!\n" +
                "\n" +
                "Điện thoại iPhone 11 giá bao nhiêu tiền?\n" +
                "Là siêu phẩm được chờ đợi nhất năm 2019, sau khoảng một thời gian ra mắt thì iPhone 11 đang có mức giá vô cùng hấp dẫn, dao động từ khoảng 13 triệu đến 19 triệu tùy theo các phiên bản khác nhau. Cụ thể như sau:\n" +
                "\n" +
                "•  Phiên bản 64GB: Giá 12.9900.000 đồng\n" +
                "\n" +
                "•  Phiên bản 128GB: Giá 14.500.000 đồng\n" +
                "\n" +
                "•  Phiên bản 256GB: Giá 19.000.000 đồng\n" +
                "\n" +
                "Tùy theo nhu cầu khác nhau, bạn có thể lựa chọn cho mình màu sắc và phiên bản dung lượng phù hợp."
                , R.drawable.iphone_11_white_4_));

        list.add(new SanPham(5, "Samsung Galaxy S22 Ultra"
                , 30990000
                , "Vi xử lý mạnh mẽ nhất Galaxy - Snapdragon 8 Gen 1 (4 nm)\n" +
                "Camera mắt thần bóng đêm Nightography - Chụp đêm cực đỉnh\n" +
                "S Pen đầu tiên trên Galaxy S - Độ trễ thấp, dễ thao tác\n" +
                "Dung lượng pin bất chấp ngày đêm - Viên pin 5000mAh, sạc nhanh 45W\n" +
                "Thông tin mới nhất về Samsung Galaxy S22 Ultra 5G\n" +
                "Đúng như theo các đồn đoán trước đó, mẫu flagship mới của Samsung được ra mắt với tên gọi là Galaxy S22 Ultra. Mẫu điện thoại cao cấp đến từ Samsung này có nhiều thay đổi trong thiết kế và cấu hình. Vậy S22 Ultra có gì mới, giá bao nhiêu và có nên mua không? Hãy cùng tìm hiểu ngay sau đây."
                , R.drawable.sm_s908_galaxys22ultra_front_green));

        list.add(new SanPham(6, "Samsung Galaxy Note 20 Ultra 5G"
                , 18990000
                , "Sang trọng, cao cấp - Màu sắc độc đáo và cuốn hút\n" +
                "Chụp ảnh chuyên nghiệp - Bộ 3 camera hỗ trợ Zoom xa đến 30X\n" +
                "Ghi chú nhanh chóng, chính xác với bút S- Pen thế hệ mới\n" +
                "Chơi game đỉnh cao - Exynos 990 7nm mạnh mẽ, hiệu năng xử lý vượt trội\n" +
                "Điện thoại Samsung Note 20 Ultra 5G - Sang trọng, hiệu năng vượt trội\n" +
                "Bên cạnh biên bản Galaxy Note 20 thường, Samsung còn cho ra mắt Note 20 Ultra 5G cho khả năng kết nối dữ liệu cao cùng thiết kế nguyên khối sang trọng, bắt mắt. Đây sẽ là sự lựa chọn hoàn hảo dành cho bạn để sử dụng mà không bị lỗi thời sau thời gian dài ra mắt.\n" +
                "\n" +
                "Ngoài ra, bạn có thể tham khảo Galaxy Z Fold 3 5G nếu bạn cần sự khác biệt và khẳng định đẳng cấp.\n" +
                "\n" +
                "Thiết kế khung nhôm nguyên khối, mặt sau kính cường lực sang trọng\n" +
                "Là một sản phẩm có kích thước màn hình lớn vì vậy Samsung đã trang bị cho Galaxy Note 20 Ultra 5G  với công nghệ kết nối dữ liệu mạnh mẽ cùng thiết kế nguyên khối. Giúp các linh kiện bên trong điện thoại được cố định chắc chắn đảm bảo mọi thứ bên trong luôn được an toàn. Không những vậy khung nhôm tạo trên những đường viền cực kỳ sang trọng và bắt mắt khi nhìn vào."
                , R.drawable.yellow_final_2));

        list.add(new SanPham(7, "Samsung Galaxy A53 (5G)"
                , 9990000
                , "Điện thoại Samsung Galaxy A53 – Hiệu năng siêu đỉnh, viên pin siêu lâu\n" +
                "Tiếp nối sự thành công của dòng điện thoại tầm trung – giá rẻ, Samsung lại cho ra mắt tiếp thế hệ tiếp theo mang tên Galaxy A53. Sản phẩm mang hiệu suất tốt, sẵn sàng mang đến cho bạn những giây phút trải nghiệm chơi game, xem phim mượt mà.\n" +
                "\n" +
                "Thiết kế gradient bắt mắt, màn hình 6.5 inches \n" +
                "Mặt lưng của điện thoại Samsung A53 chỉ được hoàn thiện từ nhựa song lại mang đến cho điện thoại trọng lượng tối ưu giúp hỗ trợ cầm nắm thoải mái. Song vẻ ngoài không bị mất giá trị bởi thiết kế gradient chuyển màu nhẹ, kết hợp với những đường nét cắt bóng theo hiệu ứng ánh sáng sẵn sàng bắt mắt người dùng."
                , R.drawable.sm_a536_galaxy_a53_5g_awesome_peach004));

        list.add(new SanPham(8, "OPPO Reno7 (5G)"
                , 12990000
                , "Trải nghiệm mọi tác vụ mượt mà - Chip MediaTek Dimensity 900 5G mạnh mẽ, RAM khủng 8 GB\n" +
                "Ghi lại những câu chuyện sống động màu sắc - Camera chính 64MP, camera selfie độ phân giải cao\n" +
                "Năng lượng bền bỉ cho cả ngày dài - Viên pin lớn 4500 mAh cùng sạc nhanh 65 W\n" +
                "Màn hình giải trí bất tận - Màn hình AMOLED 6.4\"\", tần số quét 90 Hz cho hình ảnh sống động, sắc nét\n" +
                "Điện thoại OPPO Reno 7 – Thiết kế cao cấp, chụp ảnh ấn tượng\n" +
                "OPPO là thương hiệu điện thoại nổi tiếng với khả năng chụp hình đẹp và mẫu smartphone mới OPPO Reno7 cũng không ngoại lệ. Điện thoại không chỉ sở hữu thiết kế bắt mắt, camera chất lượng mà còn được trang bị một hiệu năng vượt trội.\n" +
                "\n" +
                "Ngoài ra, bạn cũng có thể tham khảo thêm điện thoại OPPO Reno7 Z 5G với mức giá tốt hơn.\n" +
                "\n" +
                "Thiết kế vuông vức mỏng nhẹ, nhiều màu sắc sang trọng\n" +
                "Điện thoại OPPO Reno7 sở hữu một thiết kế siêu mỏng cùng khung viền vuông vức, nam tính. Máy với thiết kế cụm camera nổi bật được thiết kế lại. Nổi bật trên OPPO Reno7 đó chính là mặt lưng được thiết kế lấy cảm hứng từ sao băng mang lại lưng máy lấp lánh đẹp mắt. Máy sẽ có ba phiên bản màu sắc khác nhau cho người dùng lựa chọn là xanh, vàng và đen."
                , R.drawable.combo_product_blue_reno7_5g));

        list.add(new SanPham(8, "Laptop Asus Vivobook 13"
                , 17790000
                , "Laptop Asus Vivobook 13 Slate OLED (T3300) – laptop 2 trong 1 tiện lợi\n" +
                "Laptop Asus Vivobook 13 Slate OLED T3300 là dòng laptop 2 trong 1 hiếm hoi của thương hiệu Asus. Thiết kế độc đáo này giúp cho người dùng có một trải nghiệm thú vị.\n" +
                "\n" +
                "Thiết kế hai trong một độc đáo, bàn phím có thể tháo rời\n" +
                "Laptop Asus Vivobook 13 Slate OLED gọn nhẹ như một chiếc máy tính bảng với bàn phím có thể tháo rời. Bàn di chuột lớn hơn 50% với các sản phẩm thuộc các hãng công nghệ khác."
                , R.drawable.asus18_2_29));

        list.add(new SanPham(9, "Apple MacBook Air M1 256GB 2020"
                , 23900000
                , "Hiệu năng vượt trội - Cân mọi tác vụ từ word, exel đến chỉnh sửa ảnh trên các phần mềm như AI, PTS\n" +
                "Đa nhiệm mượt mà - Ram 8GB cho phép vừa mở trình duyệt để tra cứu thông tin, vừa làm việc trên phần mềm\n" +
                "Trang bị SSD 256GB - Cho thời gian khởi động nhanh chóng, tối ưu hoá thời gian load ứng dụng\n" +
                "Chất lượng hình ảnh sắc nét - Màn hình Retina cao cấp cùng công nghệ TrueTone cân bằng màu sắc\n" +
                "Thiết kế sang trọng - Nặng chỉ 1.29KG, độ dày 16.1mm. Tiện lợi mang theo mọi nơi\n" +
                "Macbook Air M1 2020 - Sang trọng, tinh tế, hiệu năng khủng\n" +
                "Là dòng sản phẩm có thiết kế mỏng nhẹ, sang trọng và tinh tế cùng với đó là giá thành phải chăng nên MacBook Air đã thu hút được đông đảo người dùng yêu thích và lựa chọn. Một trong những phiên bản mới nhất mà khách hàng không thể bỏ qua khi đến với CellphoneS đó là MacBook Air M1. Dưới đây là chi tiết về thiết kế, cấu hình của máy.\n" +
                "\n" +
                "Thiết kế tinh tế, chất liệu nhôm bền bỉ\n" +
                "MacBook Air 2020 M1 mới vẫn luôn tuân thủ triết lý thiết kế với những đường nét đơn nhưng vô cùng sang trọng. Máy có độ mỏng nhẹ chỉ 1,29kg và các cạnh tràn viền khiến thiết bị trở nên đẹp hơn và cao cấp hơn."
                , R.drawable.mac_air));

        list.add(new SanPham(10, "Laptop Asus Gaming Rog"
                , 21490000
                , "Laptop Asus gaming Rog Strix G15 G513IH-HN015W - Cấu hình mạnh mẽ chiến game\n" +
                "Asus ROG Strix G15 G513IH-HN015TW là chiếc laptop có cấu hình mạnh mẽ, đáp ứng được hầu hết các tựa game trên thị trường hiện nay. Ngay cả khi hoạt động trong nhiều giờ liền máy vẫn khá mát mẻ do có hệ thống tản nhiệt cao cấp. Nếu bạn là một game thủ hay người dùng muốn tìm máy có cấu hình cao thì đừng bỏ qua chiếc laptop Asus chất lượng này.\n" +
                "\n" +
                "Thiết kế mạnh mẽ\n" +
                "Asus ROG Strix G15 G513IH-HN015TW có ngoại hình vô cùng mạnh mẽ với màu sắc trang nhã. Khung máy có kích thước nhỏ hơn đến 7% so với thế hệ trước giúp bạn có thể chơi bất cứ tựa game nào mà bạn muốn. "
                , R.drawable.asus2_64_37));

        list.add(new SanPham(11, "Apple MacBook Pro 13"
                , 31000000
                , "Xử lý đồ hoạ mượt mà - Chip M1 cho phép thao tác trên các phần mềm AI, Photoshop, Render Video, phát trực tiếp ở độ phân giải 4K\n" +
                "Chất lượng hiển thị sắc nét - Độ phân giải retina màu sắc rực rỡ, tấm nền IPS cho góc nhìn 178 độ\n" +
                "Bảo mật cao - Trang bị cảm biến vân tay cho phép mở máy chỉ với 1 chạm\n" +
                "Mỏng nhẹ cao cấp - Mỏng chỉ 15.6mm, trọng lượng chỉ 1.4kg đồng hành cùng bạn mọi lúc mọi nơi\n" +
                "Cảm giác gõ thoải mái - Bàn phím magic khắc phục hầu hết các nhược điểm củ thế hệ trước\n" +
                "Macbook Pro M1 2020 – Hiệu năng vượt trội với chip M1 mạnh mẽ\n" +
                "Máy tính bảng Macbook Pro M1 thế hệ mới vừa ra mắt được trang bị vi xử lý M1 do chính Apple tự thiết kế. Hứa hẹn mang đến hiệu năng cực kì mạnh mẽ, thời gian sử dụng cực kì ấn tượng.\n" +
                "\n" +
                "Thiết kế trau chuốt từng đường nét, trải nghiệm hình ảnh sắc nét với màn hình Retina\n" +
                "Vẫn kế thừa thiết kế từ người tiềm nhiệm trước đó của mình, Macbook Pro 2020 M1 vẫn sở hữu thiết kế nhôm nguyên khối, các đường viền trên máy được cắt CNC tỉ mỉ, sắc xảo."
                , R.drawable.mbp_silver_select_spa));
    }


}
