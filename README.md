# Spring Boot Graphql
spring boot graphql application

# build and execute
[windows] -> mvnw.cmd spring-boot:run

# client (postman) 
URL -> POST : http://localhost:5555/rest/book

# query
```js
{
    allBooks {
        isn
        title
        authors
    }
}
```
```js
{
    book(id: "123") {
        isn
        title
    }
}
```
```js
{
    allBooks {
        isn
        title
    }
    book(id: "123") {
        isn
        title
        authors
        publisher
        publishedDate
    }
}
```
