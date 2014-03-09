package yaus

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "validate a link with a malformed url"() {
        given:
        def link = new Link()
        link.url = "that's not an url"
        def result = link.validate()

        expect:
        result == false
        link.errors.errorCount == 1
    }

    void "validate a link with a correct url"() {
        given:
        def link = new Link()
        link.url = "https://www.google.es/maps/place/Paseo+del+General+Mart%C3%ADnez+Campos,+20/@40.4890237,-3.6754168,11z/data=!4m2!3m1!1s0xd4228f2e1b4b3d5:0x3650e86ee12912d3"
        def result = link.validate()

        expect:
        result == true
        link.errors.errorCount == 0
    }

    void "save a link with a malformed url"() {
        given:
        def link = new Link()
        link.url = "feo"

        when:
        def saveResult = link.save(flush: true) // we force session flushing to test dateCreated autoTimestamp

        then:
        link.errors.errorCount == 1
        saveResult == null
        link.id == null
        link.dateCreated == null // should not be timestamped
    }

    void "save a link with a correct url"() {
        given:
        def link = new Link()
        link.url = "https://www.google.es/maps/place/Paseo+del+General+Mart%C3%ADnez+Campos,+20/@40.4890237,-3.6754168,11z/data=!4m2!3m1!1s0xd4228f2e1b4b3d5:0x3650e86ee12912d3"

        when:
        def saveResult = link.save(flush: true) // we force session flushing to test dateCreated autoTimestamp

        then:
        link.errors.errorCount == 0
        saveResult != null
        link.id == 1
        link.dateCreated != null // should be timestamped

        cleanup:
        link.delete()
    }
}
