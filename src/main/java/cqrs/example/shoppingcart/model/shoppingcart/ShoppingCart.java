package cqrs.example.shoppingcart.model.shoppingcart;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import cqrs.example.shoppingcart.command.AddItemCommand;
import cqrs.example.shoppingcart.event.ItemAddedEvent;

public class ShoppingCart extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public ShoppingCart() {
    }

    @CommandHandler
    public ShoppingCart(AddItemCommand command) {
        id=command.getItemId();
        apply(new ItemAddedEvent(command.getItemId(), "shoppingcart"));
    }

//    @CommandHandler
//    public ShoppingCart(RemoveItemCommand command) {
//        id=command.getItemId();
//        //put the business logic here
//        //....
//        apply(new ItemRemovedEvent(command.getItemId()));
//    }

}
