package details

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import timeline.builder.details.Country

class CountrySpec extends Specification implements DomainUnitTest<Country> {

    def setup() {
    }

    def cleanup() {
    }

    def "country name cannot be null"() {
        when:
            domain.countryName = null
        then:
            !domain.validate(['countryName'])
            domain.errors['countryName'].code == 'nullable'
    }
    def "country name cannot be blank"() {
        when:
            domain.countryName = ''
        then:
            !domain.validate(['countryName'])
    }

    // description
    def "description cannot be null"() {
        when:
            domain.description = null
        then:
            !domain.validate(['description'])
            domain.errors['description'].code == 'nullable'
    }
}
