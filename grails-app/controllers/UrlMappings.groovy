class UrlMappings {

    static mappings = {
        "/books"(controller: "book", action: "index", method: "GET")
        "/books/$id"(controller: "book", action: "show", method: "GET")
        "/health"(controller: "application", action: "index")
        "/"(redirect: "/books")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
