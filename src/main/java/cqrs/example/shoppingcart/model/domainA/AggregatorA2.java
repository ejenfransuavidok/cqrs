package cqrs.example.shoppingcart.model.domainA;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import cqrs.example.shoppingcart.command.AddItemCommand;
import cqrs.example.shoppingcart.event.ItemAddedEvent;

public class AggregatorA2 extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public AggregatorA2() {
    }

    @CommandHandler
    public AggregatorA2(AddItemCommand command) {
        id=command.getItemId();
        apply(new ItemAddedEvent(command.getItemId(), "domainA"));
    }

}
