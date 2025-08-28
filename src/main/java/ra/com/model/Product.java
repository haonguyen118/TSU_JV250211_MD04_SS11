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
    private String productName;
    @Column(name = "price", columnDefinition = "double check (price > 0)", nullable = false)
    private Double price;
    @Column(name = "stock", columnDefinition = "int check (stock >0)",nullable = false)
    private int stock;
    @Column(name = "image",nullable = false )
    private String imageUrl;
    @Column (name = "status", columnDefinition = "bit default(1)")
    private boolean status;
}
