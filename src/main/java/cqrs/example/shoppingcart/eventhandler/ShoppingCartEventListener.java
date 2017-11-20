package cqrs.example.shoppingcart.eventhandler;

import org.axonframework.eventhandling.annotation.EventHandler;

import cqrs.example.shoppingcart.event.ItemAddedEvent;
import cqrs.example.shoppingcart.event.ItemRemovedEvent;

public class ShoppingCartEventListener {

    @EventHandler
    public void onEvent(ItemAddedEvent event) {
        System.out.println("Received ItemAddedEvent id:" + event.getItemId() + " domain: " + event.getDomain()
                + " on thread named " + Thread.currentThread().getName());
    }

    @EventHandler
    public void onEvent(ItemRemovedEvent event) {
        System.out.println("Received ItemRemovedEvent id:" + event.getItemId() + " domain: " + event.getDomain()
                + " on thread named " + Thread.currentThread().getName());
    }

}