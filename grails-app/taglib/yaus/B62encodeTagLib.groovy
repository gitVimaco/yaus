package yaus

import org.vimaco.utils.Base62

class B62encodeTagLib {
    def encodeLink = {attrs, body ->
        def url = createLink(uri: '/', absolute: true) + Base62.encode(attrs.linkId)
        out << """<a href="$url">$url</a>"""
    }
}
