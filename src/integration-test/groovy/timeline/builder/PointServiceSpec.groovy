package timeline.builder

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PointServiceSpec extends Specification {

    PointService pointService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Point(...).save(flush: true, failOnError: true)
        //new Point(...).save(flush: true, failOnError: true)
        //Point point = new Point(...).save(flush: true, failOnError: true)
        //new Point(...).save(flush: true, failOnError: true)
        //new Point(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //point.id
    }

    void "test get"() {
        setupData()

        expect:
        pointService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Point> pointList = pointService.list(max: 2, offset: 2)

        then:
        pointList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pointService.count() == 5
    }

    void "test delete"() {
        Long pointId = setupData()

        expect:
        pointService.count() == 5

        when:
        pointService.delete(pointId)
        sessionFactory.currentSession.flush()

        then:
        pointService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Point point = new Point()
        pointService.save(point)

        then:
        point.id != null
    }
}
