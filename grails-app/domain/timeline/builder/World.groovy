package timeline.builder

class World {

    static hasMany = [timelines: Timeline]

    String worldName

    static constraints = {
        worldName blank: false, maxSize: 40
    }
}
