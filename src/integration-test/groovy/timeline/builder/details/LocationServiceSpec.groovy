package timeline.builder.details

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LocationServiceSpec extends Specification {

    LocationService locationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Location(...).save(flush: true, failOnError: true)
        //new Location(...).save(flush: true, failOnError: true)
        //Location location = new Location(...).save(flush: true, failOnError: true)
        //new Location(...).save(flush: true, failOnError: true)
        //new Location(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //location.id
    }

    void "test get"() {
        setupData()

        expect:
        locationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Location> locationList = locationService.list(max: 2, offset: 2)

        then:
        locationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        locationService.count() == 5
    }

    void "test delete"() {
        Long locationId = setupData()

        expect:
        locationService.count() == 5

        when:
        locationService.delete(locationId)
        sessionFactory.currentSession.flush()

        then:
        locationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Location location = new Location()
        locationService.save(location)

        then:
        location.id != null
    }
}
