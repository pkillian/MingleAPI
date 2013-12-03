# MingleAPI
## RESTful API for the Mingle application
=======

#### Routes

/

Methods: Any
Returns: hostname of server, if server is running

/auth/login
Methods: GET, POST
GET: Returns login status
POST: Authenticates to the application

/auth/logout
Methods: POST
POST: Sets user as inactive.

/msg/send
Methods: POST
POST: Inserts a message from the application to the server.

/msg/recv
Methods: GET
GET: Returns waiting messages from the server to the application
