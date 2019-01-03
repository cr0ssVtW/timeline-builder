package timeline.builder.details

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CharacterServiceSpec extends Specification {

    CharacterService characterService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Character(...).save(flush: true, failOnError: true)
        //new Character(...).save(flush: true, failOnError: true)
        //Character character = new Character(...).save(flush: true, failOnError: true)
        //new Character(...).save(flush: true, failOnError: true)
        //new Character(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //character.id
    }

    void "test get"() {
        setupData()

        expect:
        characterService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Character> characterList = characterService.list(max: 2, offset: 2)

        then:
        characterList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        characterService.count() == 5
    }

    void "test delete"() {
        Long characterId = setupData()

        expect:
        characterService.count() == 5

        when:
        characterService.delete(characterId)
        sessionFactory.currentSession.flush()

        then:
        characterService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Character character = new Character()
        characterService.save(character)

        then:
        character.id != null
    }
}
