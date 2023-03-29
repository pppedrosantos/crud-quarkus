package br.com.crud.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import br.com.crud.dto.ProductDto;
import br.com.crud.entity.Product;


@ApplicationScoped
public class ProductService {

    public List<Product> listProducts() {
        return Product.listAll();
    }

    @Transactional
    public Product saveProduct(ProductDto dto){
        Product product = new Product();

        product.setNome(dto.getNome());

        product.setPrice(dto.getPrice());

        product.persist();

        return product;

    }

    @Transactional
    public void updateProduct(Long id, ProductDto dto){
        Product product = new Product();

        Optional<Product> productOp = Product.findByIdOptional(id);

        if(productOp.isEmpty()){
            throw new NullPointerException("Product not found!");
        }

        product = productOp.get();
        product.setNome(dto.getNome());
        product.setPrice(dto.getPrice());
        product.persist();
    }

    @Transactional
    public void deleteProduct(Long id){
        Optional<Product> productOp = Product.findByIdOptional(id);

        if(productOp.isEmpty()){
            throw new NullPointerException("Product not found!");
        }

        Product product = productOp.get();

        product.delete();

    }


}