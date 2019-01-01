package timeline.builder

class Age {

    static belongsTo = [line: Line]
    static hasMany = [points: Point]

    static constraints = {
    }
}
