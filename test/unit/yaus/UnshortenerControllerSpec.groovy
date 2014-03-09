package yaus

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.vimaco.utils.Base62
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UnshortenerController)
@Mock(Link)
class UnshortenerControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index without code"() {
        when:
        controller.index()

        then:
        view == '/unshortener/error'
        model.error == 'yaus.error.url'
    }

    void "test index with empty code"() {
        given:
        params.shortCode = ""

        when:
        controller.index()

        then:
        view == '/unshortener/error'
        model.error == 'yaus.error.url'
    }

    void "test index with an invalid code"() {
        given:
        params.shortCode = "impossibleCode+" // '+' is not a possible character in our Base62 encoding algorithm

        when:
        controller.index()

        then:
        view == '/unshortener/error'
        model.error == 'yaus.error.url'
    }

    void "test index with a valid code"() {
        given:
        def SAMPLE_URL = 'http://www.example.com'
        def link = new Link(url: SAMPLE_URL, ip: '127.0.0.1')
        link.save()
        def id = link.id
        params.shortCode = Base62.encode(id)

        when:
        controller.index()

        then:
        response.redirectedUrl == SAMPLE_URL
    }
}
