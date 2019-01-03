package timeline.builder

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PointController {

    PointService pointService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pointService.list(params), model:[pointCount: pointService.count()]
    }

    def show(Long id) {
        respond pointService.get(id)
    }

    def create() {
        respond new Point(params)
    }

    def save(Point point) {
        if (point == null) {
            notFound()
            return
        }

        try {
            pointService.save(point)
        } catch (ValidationException e) {
            respond point.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'point.label', default: 'Point'), point.id])
                redirect point
            }
            '*' { respond point, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pointService.get(id)
    }

    def update(Point point) {
        if (point == null) {
            notFound()
            return
        }

        try {
            pointService.save(point)
        } catch (ValidationException e) {
            respond point.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'point.label', default: 'Point'), point.id])
                redirect point
            }
            '*'{ respond point, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pointService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'point.label', default: 'Point'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'point.label', default: 'Point'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
