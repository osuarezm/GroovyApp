package demo

class Book {
    String title
    String author
    Integer year

    static constraints = {
        title blank: false
        author blank: false
        year nullable: true
    }
}
