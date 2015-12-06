server session service using servlet
--------------------------------------

Session management is not something limited to Java and servlets. Here's roughly how it happens:

1. The HTTP protocol is stateless, so the server and the browser should have a way of storing the identity of 
the user through multiple requests

2. The browsers sends the first request to the server

3. The server checks whether the browser has identified with the session cookie (see below)

3.1. if the server doesn't 'know' the client:

* the server creates a new unique identifier, and puts it in a Map (roughly), as a key, whose value is the newly created Session. It also sends a cookie response containing the unique identifier.

* the browser stores the session cookie (with lifetime = the lifetime of the browser instance), containing the unique identifier, and uses it for each subsequent request to identify itself uniquely.

3.2. if the server already knows the client - the server obtains the Session corresponding to the passed unique identifier found in the session cookie


[What is session management in Java?](http://stackoverflow.com/a/3067421/432903)
[Confusion about how java web session handeling works. Demystifying Cookies and Header differences using servlet api and HttpSession object](http://stackoverflow.com/a/19896997/432903)
[How the clients (client sockets) are identified?](http://stackoverflow.com/questions/2439472/how-the-clients-client-sockets-are-identified/2439921#2439921)

run
-----

sbt jetty:start
