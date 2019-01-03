package timeline.builder

import grails.gorm.services.Service

@Service(Era)
interface EraService {

    Era get(Serializable id)

    List<Era> list(Map args)

    Long count()

    void delete(Serializable id)

    Era save(Era era)

}