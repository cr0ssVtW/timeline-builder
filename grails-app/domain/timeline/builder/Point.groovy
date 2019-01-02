package timeline.builder

class Point {

    static belongsTo = [era: Era]
    static hasMany = [events: Event]

    String pointName

    static constraints = {
        pointName blank: false, maxSize: 40
    }
}
