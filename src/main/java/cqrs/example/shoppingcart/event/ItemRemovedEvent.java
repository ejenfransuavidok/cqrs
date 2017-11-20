package cqrs.example.shoppingcart.event;

public class ItemRemovedEvent {

    public String getCartId() {
        return cartId;
    }

    public String getItemId() {
        return itemId;
    }

    private final String cartId;
    private final String itemId;

    public ItemRemovedEvent(String cartId, String itemId) {
        this.cartId = cartId;
        this.itemId = itemId;
    }

}