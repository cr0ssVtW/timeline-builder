package timeline.builder

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PointSpec extends Specification implements DomainUnitTest<Point> {

    Era testEra
    def setup() {
        testEra = Mock(Era) {eraTitle: "Test Era"}
    }

    def cleanup() {
    }

    // name
    def "pointName cannot be null"() {
        when:
            domain.pointName = null
        then:
            !domain.validate(['pointName'])
            domain.errors['pointName'].code == 'nullable'
    }
    def "pointName cannot be blank"() {
        when:
            domain.pointName = ''
        then:
            !domain.validate(['pointName'])
    }

    def "point era cannot be null"() {
        when:
            domain.era = null
        then:
            !domain.validate(['era'])
            domain.errors['era'].code == 'nullable'

        when:
            domain.era = testEra
        then:
            domain.validate(['era'])

    }

    // description
    def "description cannot be null"() {
        when:
            domain.description = null
        then:
            !domain.validate(['description'])
            domain.errors['description'].code == 'nullable'
    }
}
