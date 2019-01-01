package timeline.builder.details

class City {

    static belongsTo = [country: Country]

    String cityName

    static constraints = {
    }
}
