package timeline.builder

class Point {

    static belongsTo = [age: Age]
    static hasMany = [events: Event]

    String pointName

    static constraints = {
    }
}
