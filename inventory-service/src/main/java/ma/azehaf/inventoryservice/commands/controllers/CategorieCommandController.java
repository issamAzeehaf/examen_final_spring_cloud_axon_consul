package ma.azehaf.inventoryservice.commands.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.commands.CreateCategorieCommand;
import ma.azehaf.inventoryservice.commonapi.dtos.CreateCategorieRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/categorie")
@AllArgsConstructor
@Service
public class CategorieCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public CompletableFuture<String> createCategorie(@RequestBody CreateCategorieRequestDTO createcategorieRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateCategorieCommand(
                UUID.randomUUID().toString(),
                createcategorieRequestDTO.getNom(),
                createcategorieRequestDTO.getDescription()
        ));
        return response;
    }
}
