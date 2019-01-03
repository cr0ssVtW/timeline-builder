package timeline.builder

class Era {

    static belongsTo = [timeline: Timeline]
    static hasMany = [points: Point]

    String eraTitle
    String description

    static constraints = {
        eraTitle blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'text'
    }
}
