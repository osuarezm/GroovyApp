package demo

class BookController {

    static responseFormats = ['json']
    static allowedMethods = [index: "GET", show: "GET"]

    BookService bookService

    def index() {
        respond bookService.listBooks(params)
    }

    def show(Long id) {
        def dto = bookService.getBook(id)
        if (!dto) {
            render status: 404
            return
        }
        respond dto
    }
}
