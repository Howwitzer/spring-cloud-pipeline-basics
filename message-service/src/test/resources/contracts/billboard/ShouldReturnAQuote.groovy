package contracts.billboard

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method GET()
        url '/quotes/1'
        headers {
            contentType applicationJson()
        }
    }
    response {
        status OK()
        body(
            id: 1,
            quote: "to be or not to be",
            author: "Shakesheeper"
        )
        headers {
            contentType applicationJson()
        }
    }
}