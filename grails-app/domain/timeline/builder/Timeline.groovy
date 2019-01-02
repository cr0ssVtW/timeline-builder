package timeline.builder

class Timeline {

    static hasMany = [eras: Era]
    static belongsTo = [world: World]

    String timelineName


    static constraints = {
        timelineName blank: false, maxSize: 40
    }
}
