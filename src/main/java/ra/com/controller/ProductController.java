package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.com.model.DTO.req.ProductReqCreate;
import ra.com.model.DTO.req.ProductReqUpdate;
import ra.com.model.Product;
import ra.com.service.ProductService;
import ra.com.service.UploadService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UploadService uploadService;

    @GetMapping
    public String findAllProducts(Model model){
       model.addAttribute("products",productService.findAllProducts());
        return  "products";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product",new ProductReqCreate());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductReqCreate productReqCreate, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product",productReqCreate);
            return "addProduct";
        }
       Product product = new Product();
        product.setProductName(productReqCreate.getProductName());
        product.setPrice(productReqCreate.getPrice());
        product.setStock(productReqCreate.getStock());
        product.setImageUrl(uploadService.uploadFile(productReqCreate.getImageUrl()));
        product.setStatus(productReqCreate.isStatus());
        productService.addProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model){
        Product oldProduct = productService.findProductById(id);
        model.addAttribute("image",oldProduct.getImageUrl());
        model.addAttribute("id",id);
        model.addAttribute("product",productService.convertProductToProductReqUpdate(id));
        return "update";
    }
    @PostMapping("/edit/{id}")
    public String editProduct(@Valid @ModelAttribute("product")ProductReqUpdate  productReqUpdate, BindingResult bindingResult, Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productReqUpdate);
        }
        boolean result = productService.updateProduct(productReqUpdate, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        if (result) {
            redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công");
            return "redirect:/products";
        } else {
            redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thất bại");
            return "redirect:/products";
        }
    }
@GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
}
}
