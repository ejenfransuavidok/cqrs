package cqrs.example.shoppingcart.command;

import java.util.UUID;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AddItemCommand {

    @TargetAggregateIdentifier
    private String itemId;

    private Integer quantity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    private String code;

    private String description;
    private String name;

    public AddItemCommand() {
        // TODO Auto-generated constructor stub
        itemId = UUID.randomUUID().toString();

    }

    public AddItemCommand(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;

    }

}