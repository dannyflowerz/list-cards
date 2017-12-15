package io.github.dannyflowerz.listcards;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import io.github.dannyflowerz.listcards.ListCardsApplication;
import io.github.dannyflowerz.listcards.controller.ListCardsController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ListCardsApplication.class })
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    ListCardsController listCardsController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(listCardsController);
    }

    public void triggerMessage() {
        listCardsController.postCard();
    }

}
