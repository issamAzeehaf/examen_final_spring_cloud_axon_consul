package ma.azehaf.inventoryservice.commands.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.commands.CreateProduitCommand;
import ma.azehaf.inventoryservice.commonapi.dtos.CreateCategorieRequestDTO;
import ma.azehaf.inventoryservice.commonapi.dtos.CreateProduitRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/produit")
@AllArgsConstructor
@Service
public class ProduitCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public CompletableFuture<String> createCategorie(@RequestBody CreateProduitRequestDTO createProduitRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateProduitCommand(
                UUID.randomUUID().toString(),
                createProduitRequestDTO.getNom(),
                createProduitRequestDTO.getPrix(),
                createProduitRequestDTO.getQuantite(),
                createProduitRequestDTO.getCategorieId()

        ));
        return response;
    }

}
