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
    private final String domain;

    public ItemRemovedEvent(String cartId, String itemId, String domain) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

}