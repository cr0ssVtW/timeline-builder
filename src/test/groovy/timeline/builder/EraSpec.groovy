package timeline.builder

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EraSpec extends Specification implements DomainUnitTest<Era> {

    Timeline testTimeline
    def setup() {
        testTimeline = Mock(Timeline) {timelineName: "Test Timeline"}
    }

    def cleanup() {
    }

    // name
    def "eraTitle cannot be null"() {
        when:
            domain.eraTitle = null
        then:
            !domain.validate(['eraTitle'])
            domain.errors['eraTitle'].code == 'nullable'
    }
    def "eraTitle cannot be blank"() {
        when:
            domain.eraTitle = ''
        then:
            !domain.validate(['eraTitle'])
    }

    def "era timeline cannot be null"() {
        when:
            domain.timeline = null
        then:
            !domain.validate(['timeline'])
            domain.errors['timeline'].code == 'nullable'

        when:
            domain.timeline = testTimeline
        then:
            domain.validate(['timeline'])

    }
}
