package yaus

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ShortenerController)
@Mock([ShortenerService,Link])
class ShortenerControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action"() {
        when:
            controller.index()

        then:
            // We are not testing that the Grails framework is working
            // We want to test that the controller does not specify the view
            // as that is the expected behavior of the controller
            view == null
            response.redirectedUrl == null
    }

    void "test shorten action with malformed url"() {
        given:
        params.url = "that's not an url"

        when:
        def model = controller.shorten()

        then:
        def link = model.link
        link.errors.errorCount == 1
        view == null
        response.redirectedUrl == null
    }

    void "test shorten action with valid url"() {
        given:
        params.url = "http://www.example.com"

        when:
        def model = controller.shorten()

        then:
        def link = model.link
        link.errors.errorCount == 0
        link.id == 1
        link.dateCreated != null
        view == null
        response.redirectedUrl == null

        cleanup:
        link.delete()
    }
}
