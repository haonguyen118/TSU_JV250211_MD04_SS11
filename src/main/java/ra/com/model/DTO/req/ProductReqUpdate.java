package ra.com.model.DTO.req;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductReqUpdate {
    private Long id;
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String productName;
    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá của sản phẩm phải lớn hơn hoặc bằng 0")
    private Double price;
    @NotNull(message = "tồn kho không được để trống")
    @Min(value = 0, message = "Số lượng tồn kho phải lớn hơn hoặc bằng 0")
    private int stock;
    private String oldImageUrl;
    private MultipartFile imageUrl;
    private boolean status;

}

