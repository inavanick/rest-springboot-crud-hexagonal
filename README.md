## Spring Boot CRUD REST (Hexagonal Architecture)

This is a modified version of the simple Spring Boot CRUD REST app I have. This version was refactored to demo the below concepts:

* **Hexagonal Architecture** by way of creating a Maven multi-module project and adding a ***rest-springboot-crud-lib*** module containing the core logic of the application. The intention being that it could be used in any other type of *delivery mechanism (e.g. batch app)*. The ***rest-springboot-crud*** module BTW is the Spring Boot REST delivery mechanism. Although, currently missing HATEOAS links isn't completely RESTful yet.

* **Package By Feature/Component** to further enable the Hexagonal Architecture side of things, by vertically packaging the *people* service related artifacts into their own discrete packages versus the common *Package By Layer* approach. *Note that I'm referring to Java packages here.*

* **[Java Access Level Modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)** as another tool to further enable the Hexagonal Architecture.

* **Service Facade Pattern** utilized by creating an abstraction (***PeopleService***) layer in turn used in the *People* ***@RestController*** class. It's more of a Delivery Mechanism pattern than anything related to the Hexagonal Architecture. It's purpose is to provide a simplified interface for multiple sources of data on the backend of the web service(s).




