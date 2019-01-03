package timeline.builder

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TimelineServiceSpec extends Specification {

    TimelineService timelineService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Timeline(...).save(flush: true, failOnError: true)
        //new Timeline(...).save(flush: true, failOnError: true)
        //Timeline timeline = new Timeline(...).save(flush: true, failOnError: true)
        //new Timeline(...).save(flush: true, failOnError: true)
        //new Timeline(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //timeline.id
    }

    void "test get"() {
        setupData()

        expect:
        timelineService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Timeline> timelineList = timelineService.list(max: 2, offset: 2)

        then:
        timelineList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        timelineService.count() == 5
    }

    void "test delete"() {
        Long timelineId = setupData()

        expect:
        timelineService.count() == 5

        when:
        timelineService.delete(timelineId)
        sessionFactory.currentSession.flush()

        then:
        timelineService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Timeline timeline = new Timeline()
        timelineService.save(timeline)

        then:
        timeline.id != null
    }
}
