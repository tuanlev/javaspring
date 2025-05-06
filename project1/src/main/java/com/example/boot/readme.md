

# 🔍 Giải thích các thành phần:
## 🧠 Controller
+ Là trung tâm điều phối (giống "bộ não") trong hệ thống.

+ Nó nhận request từ người dùng, xử lý logic hoặc gọi service, rồi chọn View nào để trả về.

+ Trong Spring MVC, thường dùng @Controller hoặc @RestController.

## 📦 Model
Chứa dữ liệu và logic nghiệp vụ.

Ví dụ: một lớp Java Student với các thuộc tính như tên, tuổi, mã số.

Model là nơi lưu trữ, cập nhật và quản lý dữ liệu – thường liên kết với CSDL.

## 🖥️ View
Là phần hiển thị dữ liệu ra giao diện người dùng.

View thường là các file HTML, JSP, Thymeleaf,...

View lấy dữ liệu từ Model thông qua Controller để render lên UI.

📌 Mục tiêu chính của mô hình MVC:
Tách biệt trách nhiệm giữa ba thành phần để dễ bảo trì, dễ test, và tái sử dụng mã nguồn.

Ví dụ dòng chảy trong Spring MVC:
Người dùng gửi request /students.

Controller nhận request → gọi StudentService để lấy danh sách.

Service trả về list student → Controller đưa dữ liệu vào Model.

Controller trả về View (students.html) → hiển thị dữ liệu từ Model.


# KIẾN TRÚC & LUỒNG XỬ LÝ NỘI BỘ CỦA SPRING MVC ***
1. Web Client (trình duyệt hoặc ứng dụng) gửi yêu cầu HTTP.

2. Servlet Container như Tomcat sẽ nhận yêu cầu HTTP và chuyển tiếp yêu cầu đó đến Dispatcher Servlet bên trong ứng dụng web Spring.

3. Dispatcher Servlet sẽ kiểm tra Handler Mapping để xác định controller và phương thức cần gọi dựa trên HTTP method, đường dẫn, v.v.

4. Dispatcher Servlet gọi controller và phương thức tương ứng. Sau khi thực thi, controller sẽ cung cấp tên view và dữ liệu cần hiển thị trong view.

5. Dispatcher Servlet, với sự hỗ trợ của View Resolver, sẽ tìm view tương ứng và render (kết xuất) view đó với dữ liệu do controller cung cấp.

6. Servlet Container hoặc Tomcat sẽ nhận phản hồi từ Dispatcher Servlet và chuyển đổi nó thành HTTP response để trả lại cho client.

7. Trình duyệt hoặc client nhận phản hồi HTTP và hiển thị giao diện người dùng (view), dữ liệu, v.v.







