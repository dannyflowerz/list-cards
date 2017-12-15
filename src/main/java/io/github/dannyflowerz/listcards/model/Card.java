package io.github.dannyflowerz.listcards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private String pan;
    private String expirationDate; // YYMM

}
