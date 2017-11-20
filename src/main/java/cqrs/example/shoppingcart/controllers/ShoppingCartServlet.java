package cqrs.example.shoppingcart.controllers;

import cqrs.example.shoppingcart.command.AddItemCommand;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ShoppingCartServlet.class);

    @Autowired
    private CommandGateway commandGateway;

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
        commandGateway.send(addItemCommand, commandCallback);
        return "cart";
    }

}
