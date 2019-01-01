package timeline.builder

class Event {

    static belongsTo = [point: Point]
    static hasMany = [characters: Character]

    String eventName
    Date dateOfEvent // Will need to create a custom date for this


    static constraints = {
    }
}
