package timeline.builder

class Point {

    static belongsTo = [era: Era]
    static hasMany = [events: Event]

    String pointName

    String description

    static constraints = {
        pointName blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'text'
    }
}
