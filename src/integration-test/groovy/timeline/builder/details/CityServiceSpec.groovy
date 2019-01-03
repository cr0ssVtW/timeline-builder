package timeline.builder.details

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CityServiceSpec extends Specification {

    CityService cityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        //City city = new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //city.id
    }

    void "test get"() {
        setupData()

        expect:
        cityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<City> cityList = cityService.list(max: 2, offset: 2)

        then:
        cityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cityService.count() == 5
    }

    void "test delete"() {
        Long cityId = setupData()

        expect:
        cityService.count() == 5

        when:
        cityService.delete(cityId)
        sessionFactory.currentSession.flush()

        then:
        cityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        City city = new City()
        cityService.save(city)

        then:
        city.id != null
    }
}
