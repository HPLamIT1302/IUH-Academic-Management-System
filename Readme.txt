# Ứng dụng Quản Lý Học Vụ - Java Swing

## 📝 Giới thiệu
Ứng dụng được phát triển bằng **Java Swing**, sử dụng **file `.txt` làm cơ sở dữ liệu**, với giao diện trực quan và thân thiện với người dùng. Dự án áp dụng **nguyên tắc Lập trình Hướng Đối Tượng (OOP)** và được **đóng gói dưới dạng file `.jar`** để chạy độc lập.

## 🚀 Chức năng chính
- Quản lý sinh viên  
- Quản lý học phần  
- Quản lý điểm sinh viên  
- Quản lý kết quả học tập  
- Quản lý đăng ký học phần  

## 📁 Cấu trúc dữ liệu & tài khoản mẫu
- **`data_QLHocVuver6/`**: Thư mục chứa dữ liệu demo, phục vụ làm việc với file.
- **`listUserDefault`**: Danh sách tài khoản mặc định để chạy test case:
  - Tài khoản: `admin`
  - Mật khẩu: `12345`
- **`listUserDefault`** nằm trong package `model.UserDao`.

## ▶️ Hướng dẫn chạy chương trình

### ✅ Chạy bằng CMD (Command Prompt) trên Windows
1. Nhấn `Windows + R`, gõ `cmd` và nhấn Enter.
2. Dùng lệnh `cd` để điều hướng đến thư mục chứa file `.jar`.
3. Chạy chương trình với lệnh:
   ```bash
   java -jar tenFile.jar

## Chạy bằng Eclipse
-   Import toàn bộ project vào Eclipse.
-   Nếu gặp lỗi thiếu package, đảm bảo đã import đầy đủ các class cần thiết.
-   Tìm file ApplicationMain.java, chuột phải chọn:
    ```bash
    Run As → Java Application

## 📦 Công nghệ sử dụng
- Java (JDK 8+)
- Java Swing (giao diện người dùng)
- Lưu trữ dữ liệu qua file .txt

## 📌 Ghi chú
- Dự án sử dụng dữ liệu dạng tĩnh, không sử dụng cơ sở dữ liệu như MySQL.
- Phù hợp để học tập và minh họa cách tổ chức chương trình hướng đối tượng trong Java.


## Demo

![Trang login](demo_img/login.png)

![Trang Quản lý sinh viên](demo_img/QLSV.png)

![Trang Quản lý học phần](demo_img/QLHP.png)

![Trang Quản lý điểm](demo_img/QLDiem.png)

![Trang Đăng ký học phần](demo_img/QLDKHP.png)

![Trang Kết quả học tập](demo_img/KQHT.png)

