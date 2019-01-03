package timeline.builder

import grails.gorm.services.Service

@Service(Point)
interface PointService {

    Point get(Serializable id)

    List<Point> list(Map args)

    Long count()

    void delete(Serializable id)

    Point save(Point point)

}