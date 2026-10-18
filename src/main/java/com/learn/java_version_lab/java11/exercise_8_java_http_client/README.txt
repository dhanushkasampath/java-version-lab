Java 11 introduced the standardized java.net.http HTTP Client API,
including synchronous and asynchronous communication.

******* Synchronous *********

return httpClient.send(
    request, // passing the request to httpClient
    HttpResponse.BodyHandlers.ofString()
);

******* Asynchronous *********

return httpClient.sendAsync( // this is the sendAsync method.
    request,
    HttpResponse.BodyHandlers.ofString()
);

