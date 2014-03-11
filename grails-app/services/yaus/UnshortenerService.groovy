package yaus

import grails.transaction.Transactional
import org.vimaco.utils.Base62

@Transactional
class UnshortenerService {

    def unshortenUrl(code, ip) {
        def id = Base62.decode(code)
        if (id != Base62.ERROR) {
            def link = Link.get(id)
            if (link != null) {
                def visit = new Visit(link: link, ip: ip)
                visit.save()
                return link
            }
        }
        return null
    }
}
