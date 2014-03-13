package yaus

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(StatsController)
@Mock([Visit,Link])
class StatsControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action"() {
        // TODO: Testing
    }
}
