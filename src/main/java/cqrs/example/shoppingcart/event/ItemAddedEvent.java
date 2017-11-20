package cqrs.example.shoppingcart.event;

public class ItemAddedEvent {

    private final String itemId;

    public ItemAddedEvent(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

}