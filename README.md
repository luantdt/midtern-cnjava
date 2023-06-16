# 51900815_TranVuLuan_Midterm
- MSSV: 51900815
- Tên: Trần Vũ Luân
- Môn: Thực hành công nghệ Java
- Dự án giữa kỳ môn công nghệ java

# Tài khoản và database có trong dự án
- Tài khoản admin:
    + username: admin
    + password: admin
- Tài khoản người dùng 1:
    + username: vuluan
    + password: 123456
- Tài khoản người dùng 2:
    + username: test
    + password: test

- Database sẽ nằm trong folder database/
- Đường dẫn đến database diagram (sơ đồ sẽ hơi khác một chút so với dữ liệu ở trong dự án do em chưa chỉnh sửa kịp): https://drive.google.com/file/d/1gwQS744lW53fNdUUAJPF-ARtkgevv-l-/view?usp=sharing

# API có trong dự án
- GET: http://localhost:8020/
    + Hiển thị 6 sản phẩm mới nhất
- GET: http://localhost:8020/brand/*
    + Hiển thị các sản phẩm có cùng thương hiệu
- GET: http://localhost:8020/category/*
    + Hiển thị các sản phẩm có cùng loại sản phẩm
- GET: http://localhost:8020/product
    + Hiển thị tất cả các sản phẩm
- GET: http://localhost:8020/product/ *
    + Hiển thị chi tiết sản phẩm, cùng với đó là 3 sản phẩm có cùng thương hiệu
- GET: http://localhost:8020/card/checkout
    + Trang kiểm tra giỏ hàng trước khi thanh toán
- GET: http://localhost:8020/card/pay
    + Trang thanh toán các sản phẩm có trong giỏ hàng và chuyển hướng người dùng về trang chủ
- GET: http://localhost:8020/order
    + Hiển thị các đơn hàng mà khách hàng đã đặt
- GET: http://localhost:8020/login
    + Trang đăng nhập
- GET: http://localhost:8020/logout
    + Trang đăng xuất
- GET: http://localhost:8020/admin
    + Trang quản lý các sản phẩm có trong cửa hàng (chỉ dành cho người dùng admin)
- POST: http://localhost:8020/admin/add
    + API dùng để thêm sản phẩm vào cửa hàng
- POST: http://localhost:8020/admin/ *
    + API dùng để cập nhập sản phẩm trong cửa hàng
- POST: http://localhost:8020/admin/delete/ *
    + API dùng để xóa sản phẩm trong cửa hàng

# Các công nghệ sử dụng trong dự án
- spring-boot-starter-security
    + Công nghệ này được dùng trong dự án để phân quyền các trang xem người dùng có được truy cập hay không và cũng như là xử lý xem người dùng có đăng nhập chưa. Dữ liệu thông tin người dùng sẽ được lưu trong RAM của hệ thống. Các dự liệu lưu trong hệ thống như mật khẩu sẽ được mã hóa bằng thuật toán Bcrypt
- spring-boot-devtools
    + Công nghệ này dùng để tự động cập nhập mỗi khi tập tin thay đổi
- spring-boot-starter-data-jpa
    + Dùng để giao tiếp với database một cách an toàn, trách các cuộc tấn công nhắm vào các lỗi database
- spring-boot-starter-thymeleaf
    + Dùng để xem đâu là tập tin html sẽ trả về cho người dùng cũng như là hỗ trợ viết code logic trong tập tin html
- lombok
    + Sử dụng các annotation có trong thư viện để rút ngắn đoạn code
- commons-io
    + Dùng để xử lý các tập tin hình ảnh tải lên

# Config dự án
- Thông tin cấu hình dự án:
    + Dự án chạy trên cổng: 8020.
    + src/main/resources/static/ : là nơi sẽ chứa các tập tin liên quan đến js, css, images.
    + src/main/resources/templates/ : là nơi chứa các tập tin html hiển thị cho người dùng.
    + uploads: Nơi chứa các tập tin hình ảnh của admin tải lên.
- Thông tin cấu hình cơ sở dữ liệu
    + Cổng database: 3307
    + Tên database: midtern
    + tài khoản database: root
    + mật khẩu database: [trống]

