package timeline.builder

class Point {

    static belongsTo = [age: Age]
    static hasMany = [events: Event]
    static constraints = {
    }
}
