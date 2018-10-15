# Spring Boot Graphql
spring boot graphql application

# build and execute
[windows] -> mvnw.cmd springboot:run

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
    book(id: "A103") {
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
    book(id: "A109") {
        isn
        title
        authors
        publisher
        publishedDate
    }
}
```