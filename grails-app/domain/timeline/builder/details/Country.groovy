package timeline.builder.details

class Country {

    static hasMany = [cities: City]
    static belongsTo = [location: Location]

    String countryName

    static constraints = {
        countryName blank: false, maxSize: 50
    }
}
