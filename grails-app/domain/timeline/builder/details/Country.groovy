package timeline.builder.details

class Country {

    static hasMany = [cities: City]

    String countryName

    static constraints = {
        countryName blank: false, maxSize: 50
    }
}
