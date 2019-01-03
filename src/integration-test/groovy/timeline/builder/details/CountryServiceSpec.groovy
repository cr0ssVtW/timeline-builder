package timeline.builder.details

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CountryServiceSpec extends Specification {

    CountryService countryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Country(...).save(flush: true, failOnError: true)
        //new Country(...).save(flush: true, failOnError: true)
        //Country country = new Country(...).save(flush: true, failOnError: true)
        //new Country(...).save(flush: true, failOnError: true)
        //new Country(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //country.id
    }

    void "test get"() {
        setupData()

        expect:
        countryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Country> countryList = countryService.list(max: 2, offset: 2)

        then:
        countryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        countryService.count() == 5
    }

    void "test delete"() {
        Long countryId = setupData()

        expect:
        countryService.count() == 5

        when:
        countryService.delete(countryId)
        sessionFactory.currentSession.flush()

        then:
        countryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Country country = new Country()
        countryService.save(country)

        then:
        country.id != null
    }
}
