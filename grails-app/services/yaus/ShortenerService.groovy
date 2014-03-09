package yaus

import grails.transaction.Transactional

@Transactional
class ShortenerService {

    def shortenUrl(url, ip) {
        def link = null
        if (url != null) {
            link = new Link(url: url, ip: ip)
            link.save()
        }
        link
    }
}
