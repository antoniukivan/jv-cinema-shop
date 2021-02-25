# Cinema Shop

Site for booking tickets and getting a list of movie sessions. The presentation is displayed, and the data is
transmitted using JSON

# REST API

### API Reference

*PC - Personal Computer 
*http://localhost:8080 - This is Cinema Shop website API url. You can use your own localhost
server link instead default Link.

### Web API

|          Web API               |  HTTP  |                        URL                         |  Access  |
|--------------------------------|:------:|:--------------------------------------------------:|---------:|
|User register                   |POST    |/register                                           |All       |
|User login                      |POST    |/login                                              |All       |
|Get users by email              |GET     |/users/by-email?email                               |Admin     |
|Get shopping carts by user      |GET     |/shopping-carts/by-user?userId                      |User      |
|Add movie session               |POST    |/shopping-carts/movie-sessions?userId&movieSessionId|User      |
|Complete order                  |POST    |/orders/complete?userId                             |User      |
|Get orders history for user     |GET     |/orders?userId                                      |User      |
|Add cinema hall                 |POST    |/cinema-halls                                       |Admin     |
|Get all cinema halls            |GET     |/cinema-halls                                       |Admin/User|
|Add a movie                     |POST    |/movies                                             |Admin     |
|Get all movies                  |GET     |/movies                                             |Admin/User|
|Add movie session               |POST    |/movie-sessions                                     |Admin     |
|Get all available movie sessions|GET     |/movie-sessions/available?movieId=1&date=29.02.2020 |Admin/User|
|Update movie session            |PUT     |/movie-sessions/{id}                                |Admin     |
|Remove movie session            |DELETE  |/movie-sessions/{id}                                |Admin     |

### Built with

⋅⋅*Java ⋅⋅*Tomcat ⋅⋅*Maven ⋅⋅*Spring Core/MVC/Security ⋅⋅*Hibernate ⋅⋅*MySQL ⋅⋅*REST

### To start you need:
1.Download and install the JDK
2.Download and install servlet container (for example Apache Tomcat)
3.Download and install MySQL Server
*Setup new connection with:
-user: "your username"
-password: "your password"
-url: jdbc:mysql://"your host name":"your port"/"your name db"?useUnicode=true&serverTimezone=UTC
4.Run
