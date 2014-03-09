package org.vimaco.utils

import spock.lang.Specification

/**
 * Created by Vimaco on 7/03/14.
 */
class Base62Test extends Specification {
    def "Encode null"() {
        given:
        def foo = Base62.encode(null)

        expect:
        foo == null
    }

    def "Encode empty string"() {
        given:
        def foo = Base62.encode('')

        expect:
        foo == null
    }

    def "Encode decimal number"() {
        given:
        def foo = Base62.encode(1.1)

        expect:
        foo == null
    }

    def "Encode big number"() {
        given:
        def foo = Base62.encode(100000000000000000000)
        expect:
        foo != null
    }

    def "Encode inputs with known outputs"() {
        expect:
        Base62.encode(number) == hash

        where:
        number << [1, 2, 3, 4]
        hash << ['b8', 'cb', 'da', 'e5']
    }


    def "Decode null"() {
        given:
        def foo = Base62.decode(null)

        expect:
        foo == Base62.ERROR
    }

    def "Decode empty string"() {
        given:
        def foo = Base62.decode('')
        expect:
        foo == Base62.ERROR
    }

    def "Decode impossible input"() {
        given:
        def foo = Base62.decode('++') // '+' is not part of the Base62 character set

        expect:
        foo == Base62.ERROR
    }

    def "Decode inputs with known outputs"() {
        expect:
        Base62.decode(hash) == number

        where:
        number << [1, 2, 3, 4]
        hash << ['b8', 'cb', 'da', 'e5']
    }


    def "Decodes what is enconded and every code is different for different inputs"() {
        given:
        def list = []

        (1..100).toArray().each { // tested until 1000000, test takes too long with high values
            def enc = Base62.encode(it)
            list << enc
            expect:

            Base62.decode(Base62.encode(it)) == it
            !list.contains(enc)
        }
    }
}
