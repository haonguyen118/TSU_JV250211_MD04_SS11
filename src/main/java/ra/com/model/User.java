package ra.com.model;

import lombok.*;
import ra.com.customValidator.UsernameExist;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name", columnDefinition = "varchar(100)", nullable = false)
    @NotBlank(message = "Họ tên không được để trống")
    @UsernameExist
    private String userName;
    @Column(name = "password", columnDefinition = "varchar(20)", nullable = false)
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
    @Column(name = "email", columnDefinition = "varchar(100)",nullable = false)
    @NotBlank(message = "Email không được bỏ trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @Column(name = "avatar", columnDefinition = "varchar(255)", nullable = false)
    @NotBlank(message = "avatar không được để trống")
    private String avatarUrl;
}
