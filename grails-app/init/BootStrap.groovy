import demo.Book
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        // Ensure schema exists before inserting in DB
        try {
            if (Book.count() == 0) {
                def books = [
                        [title:"Clean Code", author:"Robert C. Martin", year:2008],
                        [title:"Clean Architecture", author:"Robert C. Martin", year:2017],
                        [title:"Effective Java", author:"Joshua Bloch", year:2018],
                        [title:"Refactoring", author:"Martin Fowler", year:2018],
                        [title:"Domain-Driven Design", author:"Eric Evans", year:2003],
                        [title:"Design Patterns", author:"GoF", year:1994],
                        [title:"Spring in Action", author:"Craig Walls", year:2022],
                        [title:"Microservices Patterns", author:"Chris Richardson", year:2019],
                        [title:"Java Concurrency in Practice", author:"Brian Goetz", year:2006],
                        [title:"Head First Design Patterns", author:"Eric Freeman", year:2004],
                        [title:"The Pragmatic Programmer", author:"Andrew Hunt", year:1999],
                        [title:"Working Effectively with Legacy Code", author:"Michael Feathers", year:2004],
                        [title:"Building Microservices", author:"Sam Newman", year:2021],
                        [title:"Test Driven Development", author:"Kent Beck", year:2002],
                        [title:"Patterns of Enterprise Application Architecture", author:"Martin Fowler", year:2002]
                ]

                books.each {
                    new Book(it).save(flush:true, failOnError:true)
                }

            }
        } catch (Exception e) {
            println "BootStrap seed skipped (schema not ready yet): ${e.class.simpleName} - ${e.message}"
        }
    }

    def destroy = {
    }
}
