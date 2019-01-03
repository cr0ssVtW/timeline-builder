package timeline.builder

class Timeline {

    static hasMany = [eras: Era]
    static belongsTo = [world: World]

    String timelineName

    String description

    static constraints = {
        timelineName blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'text'
    }
}
