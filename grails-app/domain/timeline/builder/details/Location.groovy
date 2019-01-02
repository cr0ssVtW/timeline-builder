package timeline.builder.details

import timeline.builder.Event

class Location {

    static belongsTo = [event: Event]
    static hasOne = [country: Country]

    String locationName

    static constraints = {
        locationName blank: false, maxSize: 50
    }
}
