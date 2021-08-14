package one.digitalinnovation.shoppingcart.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;
}
