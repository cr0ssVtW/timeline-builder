package details

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import timeline.builder.details.City
import timeline.builder.details.Country

class CitySpec extends Specification implements DomainUnitTest<City> {

    Country testCountry
    def setup() {
        testCountry = Mock(Country) {countryName: "Test"}
    }

    def cleanup() {
    }

    // name
    def "city name cannot be null"() {
        when:
            domain.cityName = null
        then:
            !domain.validate(['cityName'])
            domain.errors['cityName'].code == 'nullable'
    }
    def "city name cannot be blank"() {
        when:
            domain.cityName = ''
        then:
            !domain.validate(['cityName'])
    }

    def "city country cannot be null"() {
        when:
            domain.country = null
        then:
            !domain.validate(['country'])
            domain.errors['country'].code == 'nullable'

        when:
            domain.country = testCountry
        then:
            domain.validate(['country'])

    }
}
