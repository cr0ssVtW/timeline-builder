package timeline.builder

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EventSpec extends Specification implements DomainUnitTest<Event> {

    Point testPoint
    def setup() {
        testPoint = Mock(Point) {pointName: "Test Point"}
    }

    def cleanup() {
    }

    // name
    def "eventName cannot be null"() {
        when:
            domain.eventName = null
        then:
            !domain.validate(['eventName'])
            domain.errors['eventName'].code == 'nullable'
    }
    def "eventName cannot be blank"() {
        when:
            domain.eventName = ''
        then:
            !domain.validate(['eventName'])
    }

    def "event point cannot be null"() {
        when:
            domain.point = null
        then:
            !domain.validate(['point'])
            domain.errors['point'].code == 'nullable'

        when:
            domain.point = testPoint
        then:
            domain.validate(['point'])

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
