package yaus

class ShortenerController {
    def shortenerService

    def index() {
    }

    def shorten() {
        println "ShortenerController.shorten"
        Link link = shortenerService.shortenUrl(params.url, request.getRemoteAddr())
        println "${params.url}: ${link.errors.errorCount} ($link)"
        if (link == null || link.errors.errorCount > 0)
            render(view: 'index', model: [link: link])
        [link: link]
    }
}
