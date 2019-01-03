package timeline.builder.details

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LocationController {

    LocationService locationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond locationService.list(params), model:[locationCount: locationService.count()]
    }

    def show(Long id) {
        respond locationService.get(id)
    }

    def create() {
        respond new Location(params)
    }

    def save(Location location) {
        if (location == null) {
            notFound()
            return
        }

        try {
            locationService.save(location)
        } catch (ValidationException e) {
            respond location.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'location.label', default: 'Location'), location.id])
                redirect location
            }
            '*' { respond location, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond locationService.get(id)
    }

    def update(Location location) {
        if (location == null) {
            notFound()
            return
        }

        try {
            locationService.save(location)
        } catch (ValidationException e) {
            respond location.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'location.label', default: 'Location'), location.id])
                redirect location
            }
            '*'{ respond location, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        locationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'location.label', default: 'Location'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'location.label', default: 'Location'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
