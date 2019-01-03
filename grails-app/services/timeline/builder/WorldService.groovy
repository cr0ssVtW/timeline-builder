package timeline.builder

import grails.gorm.services.Service

@Service(World)
interface WorldService {

    World get(Serializable id)

    List<World> list(Map args)

    Long count()

    void delete(Serializable id)

    World save(World world)

}