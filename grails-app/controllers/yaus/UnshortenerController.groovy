package yaus

import org.vimaco.utils.Base62

class UnshortenerController {
    def unshortenerService

    def index() {
        def link = unshortenerService.unshortenUrl(params.code, request.getRemoteAddr())
        if (link != null) {
            redirect url: link.url
        }
        render(view: "error", model: [error: message(code: "yaus.error.url")])
    }
}
