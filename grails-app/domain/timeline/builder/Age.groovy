package timeline.builder

class Age {

    static belongsTo = [timeline: Timeline]
    static hasMany = [points: Point]

    String ageTitle


    static constraints = {
    }
}
