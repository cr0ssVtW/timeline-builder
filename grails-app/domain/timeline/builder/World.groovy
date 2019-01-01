package timeline.builder

class World {

    static hasMany = [timelines: Timeline]

    String worldName

    static constraints = {
    }
}
