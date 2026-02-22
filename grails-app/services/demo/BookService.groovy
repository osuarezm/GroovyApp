package demo

import demo.dto.BookDTO
import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class BookService {

    Map listBooks(Map params) {
        String title = params.title
        String author = params.author
        Integer year = params.year ? (params.year as Integer) : null

        Integer max = (params.max ? params.max as Integer : 10)
        max = Math.min(max, 100)
        Integer offset = (params.offset ? params.offset as Integer : 0)

        String sort = params.sort ?: 'id'
        String order = (params.order ?: 'asc').toLowerCase() == 'desc' ? 'desc' : 'asc'

        def results = Book.createCriteria().list(max: max, offset: offset, sort: sort, order: order) {
            if (title) ilike("title", "%${title}%")
            if (author) ilike("author", "%${author}%")
            if (year != null) eq("year", year)
        }

        List<BookDTO> data = results.collect { Book b ->
            new BookDTO(id: b.id, title: b.title, author: b.author, year: b.year)
        }

        [data: data, total: results.totalCount, max: max, offset: offset, sort: sort, order: order]
    }

    BookDTO getBook(Long id) {
        Book b = Book.get(id)
        if (!b) return null
        new BookDTO(id: b.id, title: b.title, author: b.author, year: b.year)
    }
}
