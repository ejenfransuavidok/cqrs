package cqrs.example.shoppingcart.controllers;

import cqrs.example.shoppingcart.command.AddItemCommand;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ShoppingCartServlet.class);

    @Autowired
    @Qualifier(value = "commandGatewayShoppingCart")
    private CommandGateway commandGatewayShoppingCart;

    @Autowired
    @Qualifier(value = "commandGatewayDomainA")
    private CommandGateway commandGatewayDomainA;

    @Autowired
    @Qualifier(value = "commandGatewayDomainB")
    private CommandGateway commandGatewayDomainB;

    @SuppressWarnings("all")
    @GetMapping("/ShoppingCartServlet")
    public String handleShoppingCartServlet(Model model,
                         @RequestParam("id") String itemId,
                         @RequestParam("quantity") Integer quantity
    ) {
        AddItemCommand addItemCommand=new AddItemCommand(itemId);
        addItemCommand.setQuantity(quantity);

        logger.debug("quantity:" + quantity);
        logger.debug("id:" + itemId);
        //asynchronous call - callback registered
        CommandCallback commandCallback = new CommandCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                logger.debug("Expected this command to fail");
            }

            @Override
            public void onFailure(Throwable cause) {
                logger.debug("command exception", cause);
            }
        };
        commandGatewayShoppingCart.send(addItemCommand, commandCallback);
        return "cart";
    }

    @SuppressWarnings("all")
    @GetMapping("/DomainAServlet")
    public String handleDomainAServlet(Model model,
                                            @RequestParam("id") String itemId,
                                            @RequestParam("quantity") Integer quantity
    ) {
        AddItemCommand addItemCommand=new AddItemCommand(itemId);
        addItemCommand.setQuantity(quantity);

        logger.debug("quantity:" + quantity);
        logger.debug("id:" + itemId);
        //asynchronous call - callback registered
        CommandCallback commandCallback = new CommandCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                logger.debug("Expected this command to fail");
            }

            @Override
            public void onFailure(Throwable cause) {
                logger.debug("command exception", cause);
            }
        };
        commandGatewayDomainA.send(addItemCommand, commandCallback);
        return "cart";
    }

    @SuppressWarnings("all")
    @GetMapping("/DomainBServlet")
    public String handleDomainBServlet(Model model,
                                       @RequestParam("id") String itemId,
                                       @RequestParam("quantity") Integer quantity
    ) {
        AddItemCommand addItemCommand=new AddItemCommand(itemId);
        addItemCommand.setQuantity(quantity);

        logger.debug("quantity:" + quantity);
        logger.debug("id:" + itemId);
        //asynchronous call - callback registered
        CommandCallback commandCallback = new CommandCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                logger.debug("Expected this command to fail");
            }

            @Override
            public void onFailure(Throwable cause) {
                logger.debug("command exception", cause);
            }
        };
        commandGatewayDomainB.send(addItemCommand, commandCallback);
        return "cart";
    }

}
