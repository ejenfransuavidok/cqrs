package cqrs.example.shoppingcart.model.domainA;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import cqrs.example.shoppingcart.command.AddItemCommand;
import cqrs.example.shoppingcart.event.ItemAddedEvent;

public class AggregatorA3 extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public AggregatorA3() {
    }

    @CommandHandler
    public AggregatorA3(AddItemCommand command) {
        id=command.getItemId();
        apply(new ItemAddedEvent(command.getItemId(), "domainA"));
    }

}
