package cqrs.example.shoppingcart.model;

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
        //put here the business logic
        //....

        apply(new ItemAddedEvent(command.getItemId()));
    }

//    @CommandHandler
//    public ShoppingCart(RemoveItemCommand command) {
//        id=command.getItemId();
//        //put the business logic here
//        //....
//        apply(new ItemRemovedEvent(command.getItemId()));
//    }

}
