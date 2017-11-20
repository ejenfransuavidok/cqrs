package cqrs.example.shoppingcart.model.domainA;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import cqrs.example.shoppingcart.command.AddItemCommand;
import cqrs.example.shoppingcart.event.ItemAddedEvent;

public class AggregatorA1 extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public AggregatorA1() {
    }

    @CommandHandler
    public AggregatorA1(AddItemCommand command) {
        id=command.getItemId();
        apply(new ItemAddedEvent(command.getItemId(), "domainA"));
    }

}
