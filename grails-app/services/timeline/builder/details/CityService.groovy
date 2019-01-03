package timeline.builder.details

import grails.gorm.services.Service

@Service(City)
interface CityService {

    City get(Serializable id)

    List<City> list(Map args)

    Long count()

    void delete(Serializable id)

    City save(City city)

}