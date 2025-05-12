## ✅ Các gói của org.springframework.data.envers (hỗ trợ audit với Envers)
1. org.springframework.data.envers.repository.config
Cấu hình cho các repository sử dụng Hibernate Envers (dùng để theo dõi lịch sử thay đổi dữ liệu – audit logging).

2. org.springframework.data.envers.repository.support
Các lớp hỗ trợ để tích hợp Hibernate Envers với Spring Data JPA (ví dụ: EnversRevisionRepositoryImpl).

## ✅ Các gói của org.springframework.data.jpa
3. org.springframework.data.jpa.convert
Hạ tầng chuyển đổi dữ liệu (converter) tùy chỉnh trong Spring Data JPA, ví dụ: AttributeConverter.

4. org.springframework.data.jpa.convert.threeten
Converter cho JSR-310 API (Java 8 Date/Time như LocalDate, LocalDateTime, v.v.).

5. org.springframework.data.jpa.domain
Các lớp hỗ trợ mô hình domain, ví dụ:

AbstractPersistable: class giúp giảm boilerplate cho entity có ID.

6. org.springframework.data.jpa.domain.support
Các lớp triển khai hỗ trợ Auditing (ghi lại ai tạo/sửa và khi nào).

Ví dụ: AuditingEntityListener dùng với @CreatedBy, @LastModifiedDate.

7. org.springframework.data.jpa.mapping
Lớp hỗ trợ ánh xạ (mapping) dữ liệu giữa entity và database.

8. org.springframework.data.jpa.projection
Hỗ trợ projection: trích xuất một phần dữ liệu từ entity, thường dùng để tối ưu truy vấn hoặc API.

Ví dụ: interface UserSummary { String getName(); }

9. org.springframework.data.jpa.provider
Các tiện ích phụ thuộc vào JPA Provider (Hibernate, EclipseLink...) như kiểm tra tính năng có được hỗ trợ hay không.

10. org.springframework.data.jpa.repository
Các interface và annotation chính để tạo JPA Repository:

JpaRepository, Query, Modifying, Lock, v.v.

11. org.springframework.data.jpa.repository.aot
Hỗ trợ AOT (Ahead-of-Time compilation) – thường dùng trong Spring Native / GraalVM context.

12. org.springframework.data.jpa.repository.cdi
Hỗ trợ tích hợp với CDI (Context & Dependency Injection) – thường dùng trong Java EE hoặc Jakarta EE.

13. org.springframework.data.jpa.repository.config
Cấu hình namespace XML và Java-based cho Spring Data JPA repositories (@EnableJpaRepositories, etc.).

14. org.springframework.data.jpa.repository.query
Các lớp hỗ trợ xử lý và thực thi query động, native query, JPQL, custom queries.

15. org.springframework.data.jpa.repository.support
Triển khai các repository: chứa các class như SimpleJpaRepository, QuerydslJpaRepository, v.v.

16. org.springframework.data.jpa.support
Các lớp trợ giúp liên quan đến JPA, ví dụ hỗ trợ transaction, entity manager...

17. org.springframework.data.jpa.util
Các tiện ích nội bộ, xử lý metadata, class introspection, v.v.