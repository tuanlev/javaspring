## Các vấn đề
# @RestController và @Controller 
Tính năng	@Controller	@RestController
Mục đích	Xử lý request và trả về view (thường là HTML)	Xây dựng RESTful API, trả về dữ liệu (ví dụ: JSON)
@ResponseBody	Cần thiết để trả về dữ liệu trực tiếp	Mặc định trả về dữ liệu trực tiếp
Kết hợp	Chỉ là @Controller	Kết hợp @Controller và @ResponseBody
#@ResponseBody mang ý nghĩa để định dạng giá trị trả về không phải view ví dụ như khi return string thì nó sẽ hiểu đó là string chứ không phải html
# @ResquestMapping và *Mapping (get,post,...)
value hoặc path:

Đây là tham số chính, chỉ định một hoặc nhiều đường dẫn URL mà phương thức controller này sẽ xử lý.
Bạn có thể sử dụng một String duy nhất hoặc một mảng String[] nếu bạn muốn ánh xạ đến nhiều đường dẫn.
Ví dụ: @GetMapping("/users") hoặc @PostMapping({"/users", "/new-user"}).
path là một bí danh của value và có cùng chức năng.
params:
Chỉ định các tham số request mà method sẽ xử lý.
Bạn có thể chỉ định sự hiện diện của một tham số ("name"), sự vắng mặt của một tham số ("!name"), hoặc giá trị cụ thể của một tham số ("name=value").
Ví dụ: @GetMapping(path = "/users", params = "active=true") (chỉ xử lý request đến /users?active=true).
Bạn có thể sử dụng nhiều điều kiện tham số: @GetMapping(path = "/items", params = {"type=book", "genre"}) (yêu cầu cả tham số type có giá trị book và tham số genre phải hiện diện).
headers:

Chỉ định các header request mà method sẽ xử lý.
Tương tự như params, bạn có thể chỉ định sự hiện diện ("X-Custom-Header"), sự vắng mặt ("!X-Custom-Header"), hoặc giá trị cụ thể ("Content-Type=application/json").
Ví dụ: @PostMapping(path = "/upload", headers = "Content-Type=multipart/form-data").
consumes:

Chỉ định kiểu media mà request chấp nhận (Content-Type của request).
Sử dụng để giới hạn các request mà method có thể xử lý dựa trên kiểu dữ liệu được gửi từ client.
Ví dụ: @PostMapping(path = "/data", consumes = "application/json") (chỉ xử lý các request có header Content-Type: application/json).
Bạn có thể chỉ định nhiều kiểu media: @PostMapping(path = "/data", consumes = {"application/json", "text/xml"}).
produces:

Chỉ định kiểu media mà response trả về (Content-Type của response).
Sử dụng để chỉ định định dạng dữ liệu mà server sẽ trả về cho client.
Ví dụ: @GetMapping(path = "/info", produces = "application/json") (response sẽ có header Content-Type: application/json).
Bạn có thể chỉ định nhiều kiểu media: @GetMapping(path = "/data", produces = {"application/json", "application/xml"}). Spring sẽ cố gắng chọn kiểu phù hợp dựa trên header Accept của request.

đối với ResquestMapping thì thêm method

# @ResquestBody tùy chọn có hay không body 
 @RequestParam("category") String category,
            @RequestParam(value = "price", required = false) Double priceLimit,
            @RequestParam(defaultValue = "false") boolean available,
            @RequestParam("color") List<String> colors,
            @RequestParam("releaseDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate