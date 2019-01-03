package timeline.builder.details

import timeline.builder.Event

class Location {

    static belongsTo = [event: Event]

    String locationName
    Country country

    static constraints = {
        locationName blank: false, maxSize: 50
        country nullable: true
    }
}
