package timeline.builder

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EraServiceSpec extends Specification {

    EraService eraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Era(...).save(flush: true, failOnError: true)
        //new Era(...).save(flush: true, failOnError: true)
        //Era era = new Era(...).save(flush: true, failOnError: true)
        //new Era(...).save(flush: true, failOnError: true)
        //new Era(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //era.id
    }

    void "test get"() {
        setupData()

        expect:
        eraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Era> eraList = eraService.list(max: 2, offset: 2)

        then:
        eraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        eraService.count() == 5
    }

    void "test delete"() {
        Long eraId = setupData()

        expect:
        eraService.count() == 5

        when:
        eraService.delete(eraId)
        sessionFactory.currentSession.flush()

        then:
        eraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Era era = new Era()
        eraService.save(era)

        then:
        era.id != null
    }
}
