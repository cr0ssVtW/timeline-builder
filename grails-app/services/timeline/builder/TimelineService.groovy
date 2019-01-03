package timeline.builder

import grails.gorm.services.Service

@Service(Timeline)
interface TimelineService {

    Timeline get(Serializable id)

    List<Timeline> list(Map args)

    Long count()

    void delete(Serializable id)

    Timeline save(Timeline timeline)

}