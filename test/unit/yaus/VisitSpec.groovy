package yaus

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Visit)
@Mock([Link])
class VisitSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Save visit without a link"() {
        given:
        def visit = new Visit()

        when:
        def result = visit.save(flush: true)

        then:
        result == null
        visit.errors.errorCount == 1
        visit.id == null
        visit.dateCreated == null
    }

    void "Save visit with a link"() {
        given:
        def link = new Link(url: 'http://www.example.com')
        def visit = new Visit(link: link)

        when:
        def result = visit.save(flush: true, failOnError: true)

        then:
        result != null // link saved
        visit.errors.errorCount == 0 // visit validation OK
        visit.id != null // visit persisted
        visit.dateCreated != null // autotimestamping is working

        cleanup:
        visit.delete(flush: true, failOnError: true)
    }
}
