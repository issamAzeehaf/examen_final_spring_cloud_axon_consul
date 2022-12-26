package ma.azehaf.customerservice.commands.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.customerservice.commonapi.commands.CreateCustomerCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/commands/customer")
@AllArgsConstructor
public class CustomerCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerCommand requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                requestDTO.getNom(),
                requestDTO.getAdresse(),
                requestDTO.getEmail(),
                requestDTO.getTelephone()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return responseEntity;
    }

    @GetMapping("/eventStore/{radarId}")
    public Stream eventStore(@PathVariable String customerId){
        return eventStore.readEvents(customerId).asStream();
    }
}
