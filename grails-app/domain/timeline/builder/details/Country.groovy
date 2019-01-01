package timeline.builder.details

class Country {

    static hasMany = [cities: City]

    String countryName

    static constraints = {
    }
}
