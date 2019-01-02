package timeline.builder.details

class City {

    static belongsTo = [country: Country]

    String cityName

    static constraints = {
        cityName blank: false, maxSize: 40
    }
}
