import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a  list of cards"
    request {
        url "/cards"
        method GET()
    }
    response {
        status 200
        body("{\"microservices\":\"demo\"}")
    }
}