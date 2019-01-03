package timeline.builder

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WorldServiceSpec extends Specification {

    WorldService worldService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new World(...).save(flush: true, failOnError: true)
        //new World(...).save(flush: true, failOnError: true)
        //World world = new World(...).save(flush: true, failOnError: true)
        //new World(...).save(flush: true, failOnError: true)
        //new World(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //world.id
    }

    void "test get"() {
        setupData()

        expect:
        worldService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<World> worldList = worldService.list(max: 2, offset: 2)

        then:
        worldList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        worldService.count() == 5
    }

    void "test delete"() {
        Long worldId = setupData()

        expect:
        worldService.count() == 5

        when:
        worldService.delete(worldId)
        sessionFactory.currentSession.flush()

        then:
        worldService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        World world = new World()
        worldService.save(world)

        then:
        world.id != null
    }
}
