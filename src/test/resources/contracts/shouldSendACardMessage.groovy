import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should send a card message"
    label "triggerCard"
    input {
        triggeredBy("triggerMessage()")
    }
    outputMessage {
        sentTo "cards"
        body("{\"pan\":\"112233445566778899\",\"expirationDate\":\"1906\"}")
    }
}