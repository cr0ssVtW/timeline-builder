package timeline.builder

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TimelineController {

    TimelineService timelineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond timelineService.list(params), model:[timelineCount: timelineService.count()]
    }

    def show(Long id) {
        respond timelineService.get(id)
    }

    def create() {
        respond new Timeline(params)
    }

    def save(Timeline timeline) {
        if (timeline == null) {
            notFound()
            return
        }

        try {
            timelineService.save(timeline)
        } catch (ValidationException e) {
            respond timeline.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'timeline.label', default: 'Timeline'), timeline.id])
                redirect timeline
            }
            '*' { respond timeline, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond timelineService.get(id)
    }

    def update(Timeline timeline) {
        if (timeline == null) {
            notFound()
            return
        }

        try {
            timelineService.save(timeline)
        } catch (ValidationException e) {
            respond timeline.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'timeline.label', default: 'Timeline'), timeline.id])
                redirect timeline
            }
            '*'{ respond timeline, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        timelineService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'timeline.label', default: 'Timeline'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeline.label', default: 'Timeline'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
