package details

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import timeline.builder.details.Character
import timeline.builder.details.City

class CharacterSpec extends Specification implements DomainUnitTest<Character> {

    private City testCity

    def setup() {
        testCity = Mock(City);
    }

    def cleanup() {
    }

    // name
    def "character name cannot be null"() {
        when:
            domain.characterName = null
        then:
            !domain.validate(['characterName'])
            domain.errors['characterName'].code == 'nullable'
    }
    def "character name cannot be blank"() {
        when:
            domain.characterName = ''
        then:
            !domain.validate(['characterName'])
    }
    // race
    def "character race cannot be null"() {
        when:
            domain.race = null
        then:
            !domain.validate(['race'])
            domain.errors['race'].code == 'nullable'
    }
    def "character race cannot be blank"() {
        when:
            domain.race = ''
        then:
            !domain.validate(['race'])
    }
    // gender
    def "character gender cannot be null"() {
        when:
            domain.characterName = null
        then:
            !domain.validate(['gender'])
            domain.errors['gender'].code == 'nullable'
    }
    def "character gender cannot be blank"() {
        when:
            domain.characterName = ''
        then:
            !domain.validate(['gender'])
    }
    // city
    def "character city can be nullable"() {
        when:
            domain.residence = null
        then:
            domain.validate(['residence'])
    }

}
