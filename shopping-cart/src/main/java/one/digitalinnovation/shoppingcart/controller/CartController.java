package one.digitalinnovation.shoppingcart.controller;

import one.digitalinnovation.shoppingcart.model.Cart;
import one.digitalinnovation.shoppingcart.model.Item;
import one.digitalinnovation.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        }else{
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }
    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id){
        return cartRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public void clear(@PathVariable Integer id){
        cartRepository.deleteById(id);
    }
}
