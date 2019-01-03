package timeline.builder.details

class City {

    static belongsTo = [country: Country]

    String cityName

    String description

    static constraints = {
        cityName blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'text'
    }
}
