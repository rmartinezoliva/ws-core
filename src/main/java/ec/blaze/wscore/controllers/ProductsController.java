package ec.blaze.wscore.controllers;

import java.util.HashMap;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.blaze.wscore.model.Product;
import ec.blaze.wscore.request.RequestId;
import ec.blaze.wscore.request.RequestProduct;
import ec.blaze.wscore.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Class ws admin products
 * @author Ruben Martínez
 *
 */

@RestController
@RequestMapping("/api/products")
@Api(tags="products")
public class ProductsController {
	
	@Autowired
	public ProductService productService;
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@GetMapping
	@ApiOperation(value = "Product list" , notes = "Show list of the product")
	public ResponseEntity<?> list() {		
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
	
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(
				err -> errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errores);
	}
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PostMapping
	@ApiOperation(value = "Create product" , notes = "Create a new product")
	public ResponseEntity<?> create(@Valid @RequestBody RequestProduct payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Product product = new Product();
		product.setName(payload.getName());
		product.setCategory(payload.getCategory());
		product.setStatus(payload.getStatus());
		product.setPrice(payload.getPrice());
		
		try {
		product = productService.save(product);
		}catch(Exception e) {}
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PostMapping("/product")
	@ApiOperation(value = "Get product" , notes = "Get product")
	public ResponseEntity<?> create(@Valid @RequestBody RequestId payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		return new ResponseEntity<>(productService.findOneById(payload.getId()), HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@DeleteMapping
	@ApiOperation(value = "Delete product" , notes = "Delete product")
	public ResponseEntity<?> delete(@Valid @RequestBody RequestId payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		int a=0;
		try {
		Product product =productService.findOneById(payload.getId());
		productService.delete(product);
		a=1;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = {"http://localhost:3005"})
	@PutMapping
	@ApiOperation(value = "Edit product" , notes = "Edit a new product")
	public ResponseEntity<?> update(@Valid @RequestBody RequestProduct payload , BindingResult result) {	
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Product product = new Product();
		product.setName(payload.getName());
		product.setCategory(payload.getCategory());
		product.setStatus(payload.getStatus());
		product.setPrice(payload.getPrice());
		product.setId(payload.getId());
		
		try {
		product = productService.save(product);
		}catch(Exception e) {}
		
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

}
