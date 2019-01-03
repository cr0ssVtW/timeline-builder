package timeline.builder

import grails.gorm.services.Service

@Service(Event)
interface EventService {

    Event get(Serializable id)

    List<Event> list(Map args)

    Long count()

    void delete(Serializable id)

    Event save(Event event)

}