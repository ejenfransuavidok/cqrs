package cqrs.example.shoppingcart.event;

public class ItemAddedEvent {

    private final String itemId;
    private final String domain;

    public ItemAddedEvent(String itemId, String domain) {
        this.itemId = itemId;
        this.domain = domain;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDomain() {
        return domain;
    }

}