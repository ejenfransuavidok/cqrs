package cqrs.example.shoppingcart.model.domainB;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import cqrs.example.shoppingcart.command.AddItemCommand;
import cqrs.example.shoppingcart.event.ItemAddedEvent;

public class AggregatorB3 extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public AggregatorB3() {
    }

    @CommandHandler
    public AggregatorB3(AddItemCommand command) {
        id=command.getItemId();
        apply(new ItemAddedEvent(command.getItemId(), "domainB"));
    }

}
