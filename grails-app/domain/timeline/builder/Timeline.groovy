package timeline.builder

class Timeline {

    static hasMany = [ages: Age]
    static belongsTo = [world: World]

    String timelineName


    static constraints = {
    }
}
