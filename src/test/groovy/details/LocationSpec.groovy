package details

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import timeline.builder.Event
import timeline.builder.details.Location

class LocationSpec extends Specification implements DomainUnitTest<Location> {

    Event testEvent
    def setup() {
        testEvent = Mock(Event) {eventName: "TestEvent"}
    }

    def cleanup() {
    }

    // name
    def "locationName cannot be null"() {
        when:
            domain.locationName = null
        then:
            !domain.validate(['locationName'])
            domain.errors['locationName'].code == 'nullable'
    }
    def "locationName cannot be blank"() {
        when:
            domain.locationName = ''
        then:
            !domain.validate(['locationName'])
    }

    def "location event cannot be null"() {
        when:
            domain.event = null
        then:
            !domain.validate(['event'])
            domain.errors['event'].code == 'nullable'

        when:
            domain.event = testEvent
        then:
            domain.validate(['event'])

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
