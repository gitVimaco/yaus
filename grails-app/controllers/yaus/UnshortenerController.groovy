package yaus

import org.vimaco.utils.Base62

class UnshortenerController {

    def index() {
        println "UnshortenerController.index: ${params.code}"
        def id = Base62.decode(params.code)
        if (id != Base62.ERROR) {
            def link = Link.get(id)
            if (link != null) {
                println "redirect to ${link.url}"
                redirect url: link.url
            }

        }
        render(view: "error", model: [error: message(code: "yaus.error.url")])
    }
}
