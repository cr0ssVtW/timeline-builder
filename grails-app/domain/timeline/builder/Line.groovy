package timeline.builder

class Line {

    static hasMany = [ages: Age]
    static belongsTo = [world: World]

    String lineName


    static constraints = {
    }
}
