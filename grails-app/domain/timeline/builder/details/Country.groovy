package timeline.builder.details

class Country {

    static hasMany = [cities: City]

    String countryName

    String description

    static constraints = {
        countryName blank: false, maxSize: 50
    }

    static mapping = {
        description sqlType: 'text'
    }
}
