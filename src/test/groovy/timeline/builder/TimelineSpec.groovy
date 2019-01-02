package timeline.builder

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TimelineSpec extends Specification implements DomainUnitTest<Timeline> {

    World testWorld

    def setup() {
        testWorld = Mock(World) {worldName: "Test World"}
    }

    def cleanup() {
    }

    // name
    def "timelineName cannot be null"() {
        when:
            domain.timelineName = null
        then:
            !domain.validate(['timelineName'])
            domain.errors['timelineName'].code == 'nullable'
    }
    def "timelineName cannot be blank"() {
        when:
            domain.timelineName = ''
        then:
            !domain.validate(['timelineName'])
    }

    def "timeline world cannot be null"() {
        when:
            domain.world = null
        then:
            !domain.validate(['world'])
            domain.errors['world'].code == 'nullable'

        when:
            domain.world = testWorld
        then:
            domain.validate(['world'])

    }
}
