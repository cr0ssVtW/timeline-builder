package timeline.builder

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WorldSpec extends Specification implements DomainUnitTest<World> {

    def setup() {
    }

    def cleanup() {
    }

    // name
    def "worldName cannot be null"() {
        when:
            domain.worldName = null
        then:
            !domain.validate(['worldName'])
            domain.errors['worldName'].code == 'nullable'
    }
    def "worldName cannot be blank"() {
        when:
            domain.worldName = ''
        then:
            !domain.validate(['worldName'])
    }
}
