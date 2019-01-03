package timeline.builder.details

import grails.gorm.services.Service

@Service(Character)
interface CharacterService {

    Character get(Serializable id)

    List<Character> list(Map args)

    Long count()

    void delete(Serializable id)

    Character save(Character character)

}