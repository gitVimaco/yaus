package yaus

class ShortenerController {
    def shortenerService

    def index() {
    }

    def shorten() {
        Link link = shortenerService.shortenUrl(params.url, request.getRemoteAddr())
        if (link == null || link.errors.errorCount > 0)
            render(view: 'index', model: [link: link])
        [link: link]
    }
}
