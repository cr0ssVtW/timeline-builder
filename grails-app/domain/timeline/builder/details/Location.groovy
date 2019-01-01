package timeline.builder.details

import timeline.builder.Event

class Location {

    static belongsTo = [event: Event]

    String locationName

    static constraints = {
    }
}
