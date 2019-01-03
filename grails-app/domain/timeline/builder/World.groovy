package timeline.builder

class World {

    static hasMany = [timelines: Timeline]

    String worldName

    String description

    static constraints = {
        worldName blank: false, maxSize: 40
    }

    static mapping = {
        description sqlType: 'longText'
    }
}
