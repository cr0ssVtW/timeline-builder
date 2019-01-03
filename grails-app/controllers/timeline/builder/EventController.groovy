package timeline.builder

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EventController {

    EventService eventService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eventService.list(params), model:[eventCount: eventService.count()]
    }

    def show(Long id) {
        respond eventService.get(id)
    }

    def create() {
        respond new Event(params)
    }

    def save(Event event) {
        if (event == null) {
            notFound()
            return
        }

        try {
            eventService.save(event)
        } catch (ValidationException e) {
            respond event.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'event.label', default: 'Event'), event.id])
                redirect event
            }
            '*' { respond event, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond eventService.get(id)
    }

    def update(Event event) {
        if (event == null) {
            notFound()
            return
        }

        try {
            eventService.save(event)
        } catch (ValidationException e) {
            respond event.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'event.label', default: 'Event'), event.id])
                redirect event
            }
            '*'{ respond event, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        eventService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'event.label', default: 'Event'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
