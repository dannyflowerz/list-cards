package io.github.dannyflowerz.listcards.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.dannyflowerz.listcards.model.Card;

@RestController
@EnableBinding(Source.class)
public class ListCardsController {

    @Autowired private Source source;

    @AllArgsConstructor
    @Getter
    @Setter
    private class DemoPojo {
        private String microservices;
    }

    @GetMapping("/cards")
    public ResponseEntity<DemoPojo> getCards() {
        return ResponseEntity.ok().body(new DemoPojo("demo"));
    }

    @PostMapping("/message")
    public void postCard() {
        source.output().send(MessageBuilder.withPayload(Card.builder().pan("112233445566778899").expirationDate("1906").build()).build());
    }

}
