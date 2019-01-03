package timeline.builder.details

class Character {

    String characterName
    Date dateOfBirth // Custom dates
    String race
    String gender
    City residence

    String description

    static constraints = {
        characterName blank: false, maxSize: 50
        race blank: false, maxSize: 50
        gender blank: false, maxSize: 20
        residence nullable: true
    }

    static mapping = {
        description sqlType: 'text'
    }
}
