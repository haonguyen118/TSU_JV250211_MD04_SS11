package ra.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", columnDefinition = "varchar (50)", nullable = false,unique = true)
    @NotEmpty(message = "tên sản phẩm không được để trống")
    private String productName;
    @Column(name = "price", columnDefinition = "double check (price > 0", nullable = false)
    @NotEmpty(message = "Giá sản phẩm không được để trống")
    private Double price;
    @Column(name = "stock", columnDefinition = "int check (stock >=0)",nullable = false)
    @NotEmpty(message = "Tồn kho không được để trống")
    private int stock;
    @Column(name = "image",nullable = false )
    @NotEmpty(message = "ảnh không được để trống")
    private String image;
    o
}
