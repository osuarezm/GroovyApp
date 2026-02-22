package demo

class ApplicationController {
    static responseFormats = ['json']
    def index() {
        respond([status: "ok"])
    }
}
