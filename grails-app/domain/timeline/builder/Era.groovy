package timeline.builder

class Era {

    static belongsTo = [timeline: Timeline]
    static hasMany = [points: Point]

    String eraTitle


    static constraints = {
        eraTitle blank: false, maxSize: 40
    }
}
