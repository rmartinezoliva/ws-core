ws-core
==========================

#What is it?

WS - CORE is an interesting projetc, that aims at simplifying Spring project setup. 

So if you have no experience with XML-less Spring setup, this simple project is an example, to checkout out.  It is based on official https://spring.io/guides/gs/spring-boot but extended and configured to include a set of tool, that you are likely to use (Groovy, Spock, Spring Data, etc.).

# How to run it?

If you have gradle installed and under linux/mac:

    gradle runJar

If gradle is not installed, but still under linux/mac

    gradlew runJar

And for windows without gradle

    gradlew.bat runJar

After the server is running, go to

```
http://localhost:8080/index.html
user: test
password: test 
```

The backend is done with 
- Spring Boot 0.5.0.M5
- Spring 4.0.0.M3
- Hibernate 4.2.1 
- Spring MVC, Spring Data JPA, Spring security and so on.

There is embedded tomcat and embedded, in-memory hsql inside.

There is a standard set of libs, like guava, joda-time and so on.
