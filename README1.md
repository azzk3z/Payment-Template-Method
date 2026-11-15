HỆ THỐNG XỬ LÝ THANH TOÁN – TEMPLATE METHOD DESIGN PATTERN

1. Giới thiệu đề tài

Tên đề tài: Xây dựng hệ thống xử lý thanh toán.

Ngôn ngữ: Java.

Design Pattern: Template Method.

Mục đích: Áp dụng mẫu thiết kế Template Method để xây dựng quy trình thanh toán có các bước xử lý chung và các bước có thể thay đổi tùy theo phương thức thanh toán.

Hệ thống mô phỏng ba phương thức thanh toán:

Cash Payment – Thanh toán tiền mặt.

Credit Card Payment – Thanh toán bằng thẻ ngân hàng.

E-Wallet Payment – Thanh toán bằng ví điện tử.

2. Phân tích bài toán

Trong hệ thống thương mại điện tử, các phương thức thanh toán khác nhau thường có quy trình xử lý tương tự nhau.

Quy trình thanh toán gồm 5 bước:

Kiểm tra thông tin đơn hàng.

Kiểm tra số tiền thanh toán.

Thực hiện giao dịch.

Lưu thông tin giao dịch.

Thông báo kết quả cho khách hàng.

Trong đó, bước 3 thay đổi tùy theo phương thức thanh toán. Các bước còn lại được sử dụng chung.

3. Áp dụng Template Method Design Pattern

Template Method là mẫu thiết kế hành vi, cho phép định nghĩa khung thuật toán trong một lớp cha và giao việc triển khai một số bước cụ thể cho các lớp con.

Trong chương trình, lớp trừu tượng PaymentProcessor đóng vai trò định nghĩa khung thuật toán thông qua phương thức:

processPayment(Order order)

Phương thức này quy định thứ tự thực hiện các bước xử lý thanh toán và được khai báo final để các lớp con không thể thay đổi quy trình chung.

Phương thức executePayment(Order order) được khai báo trừu tượng. Các lớp con sẽ ghi đè phương thức này để triển khai cách thanh toán riêng.

4. Giải thích các lớp trong chương trình

Lớp

Chức năng

Order

Lưu trữ mã đơn hàng, tên khách hàng và số tiền thanh toán.

PaymentProcessor

Lớp trừu tượng định nghĩa khung thuật toán thanh toán.

CashPayment

Triển khai phương thức thanh toán tiền mặt.

CreditCardPayment

Triển khai phương thức thanh toán bằng thẻ ngân hàng.

EWalletPayment

Triển khai phương thức thanh toán bằng ví điện tử.

Main

Khởi tạo đơn hàng và kiểm thử các phương thức thanh toán.

4.1. Lớp PaymentProcessor

Đây là lớp quan trọng nhất của chương trình.

processPayment(): Template Method, định nghĩa trình tự xử lý thanh toán.

validateOrder(): Kiểm tra thông tin đơn hàng.

validateAmount(): Kiểm tra số tiền thanh toán.

executePayment(): Phương thức trừu tượng, được triển khai ở lớp con.

saveTransaction(): Lưu thông tin giao dịch.

notifyCustomer(): Thông báo kết quả thanh toán.

4.2. Các lớp thanh toán cụ thể

CashPayment: Mô phỏng việc khách hàng thanh toán tiền mặt.

CreditCardPayment: Kiểm tra thông tin thẻ và mô phỏng xác thực giao dịch.

EWalletPayment: Kiểm tra tài khoản ví và mô phỏng xác thực giao dịch.

Các lớp này kế thừa PaymentProcessor và ghi đè phương thức executePayment().

5. Sơ đồ UML lớp

Sơ đồ mô tả lớp trừu tượng PaymentProcessor, ba lớp thanh toán cụ thể và lớp Order.

Sơ đồ UML: <img width="726" height="252" alt="image" src="https://github.com/user-attachments/assets/f116a28b-34e3-4ca5-8ca8-a49605bf36b5" />


6. Kết quả thực nghiệm

Chương trình được kiểm thử với bốn trường hợp:

Test Case

Phương thức thanh toán

Kết quả

TC01

Cash Payment

Thành công

<img width="446" height="425" alt="image" src="https://github.com/user-attachments/assets/421ccca9-e1cd-4678-b3dc-7a218f1b3927" />

TC02

Credit Card Payment

Thành công

<img width="450" height="428" alt="image" src="https://github.com/user-attachments/assets/7dbfb750-ca0c-438a-b3e6-6becb47955d7" />

TC03

E-Wallet Payment

Thành công

<img width="441" height="431" alt="image" src="https://github.com/user-attachments/assets/ab72bab1-9679-4927-af36-36cc71b7a95d" />

TC04

Credit Card không hợp lệ

Thất bại

<img width="431" height="256" alt="image" src="https://github.com/user-attachments/assets/3572e49f-53ac-4c3a-9de9-287064d114fc" />

Kết quả cho thấy các phương thức thanh toán sử dụng cùng một quy trình xử lý tổng thể, nhưng có cách triển khai giao dịch riêng.

7. Hướng dẫn chạy chương trình

Clone Repository về máy tính.

Mở project bằng Eclipse hoặc IntelliJ IDEA.

Kiểm tra package payment.

Chạy file Main.java.

Quan sát kết quả trong cửa sổ Console.

Clone Repository

git clone https://github.com/azzk3z/Payment-Template-Method.git

8. Lợi ích của Template Method

Tái sử dụng các bước xử lý chung.

Giảm trùng lặp mã nguồn.

Dễ dàng bổ sung phương thức thanh toán mới.

Đảm bảo các phương thức thanh toán tuân theo cùng một quy trình.

Dễ bảo trì và mở rộng hệ thống.

9. Kết luận

Thông qua bài tập, mẫu thiết kế Template Method được áp dụng để giải quyết bài toán xử lý thanh toán.

Chương trình thể hiện rõ việc tách biệt quy trình xử lý chung và các bước triển khai riêng biệt, giúp mã nguồn có cấu trúc rõ ràng, dễ mở rộng và bảo trì.
