package timeline.builder

import timeline.builder.details.Character
import timeline.builder.details.Location

class Event {

    static belongsTo = [point: Point]
    static hasMany = [characters: Character, locations: Location]

    String eventName
    Date dateOfEvent // Will need to create a custom date for this

    String description


    static constraints = {
        eventName blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'longText'
    }
}
