package ra.com.model.DTO.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ra.com.customValidator.ProductNameExist;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReqCreate {
    @NotBlank(message = "Tên sản phẩm không được để trống")
    @ProductNameExist(message = "Tên sản phẩm đã tồn tại")
    private String productName;
    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá của sản phẩm phải lớn hơn hoặc bằng 0")
    private Double price;
    @NotNull(message = "tồn kho không được để trống")
    @Min(value = 0,message = "Số lượng tồn kho phải lớn hơn hoặc bằng 0")
    private int stock;
    private MultipartFile imageUrl;
    private boolean status;
}
