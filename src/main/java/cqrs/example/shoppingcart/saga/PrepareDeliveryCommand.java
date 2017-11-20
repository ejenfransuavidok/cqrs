package cqrs.example.shoppingcart.saga;

import java.util.UUID;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class PrepareDeliveryCommand {

    @TargetAggregateIdentifier
    private String shippingId;

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

    public void setAddress(String address) {
        this.address = address;
    }

    private String code;

    private String description;
    private String name;
    private String address;

    public PrepareDeliveryCommand() {
        // TODO Auto-generated constructor stub
        shippingId = UUID.randomUUID().toString();

    }

    public PrepareDeliveryCommand(String shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingId() {
        return shippingId;
    }


}