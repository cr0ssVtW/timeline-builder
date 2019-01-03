package timeline.builder

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EraController {

    EraService eraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eraService.list(params), model:[eraCount: eraService.count()]
    }

    def show(Long id) {
        respond eraService.get(id)
    }

    def create() {
        respond new Era(params)
    }

    def save(Era era) {
        if (era == null) {
            notFound()
            return
        }

        try {
            eraService.save(era)
        } catch (ValidationException e) {
            respond era.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'era.label', default: 'Era'), era.id])
                redirect era
            }
            '*' { respond era, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond eraService.get(id)
    }

    def update(Era era) {
        if (era == null) {
            notFound()
            return
        }

        try {
            eraService.save(era)
        } catch (ValidationException e) {
            respond era.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'era.label', default: 'Era'), era.id])
                redirect era
            }
            '*'{ respond era, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        eraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'era.label', default: 'Era'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'era.label', default: 'Era'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
