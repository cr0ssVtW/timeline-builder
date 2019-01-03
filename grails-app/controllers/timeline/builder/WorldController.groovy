package timeline.builder

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WorldController {

    WorldService worldService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond worldService.list(params), model:[worldCount: worldService.count()]
    }

    def show(Long id) {
        respond worldService.get(id)
    }

    def create() {
        respond new World(params)
    }

    def save(World world) {
        if (world == null) {
            notFound()
            return
        }

        try {
            worldService.save(world)
        } catch (ValidationException e) {
            respond world.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'world.label', default: 'World'), world.id])
                redirect world
            }
            '*' { respond world, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond worldService.get(id)
    }

    def update(World world) {
        if (world == null) {
            notFound()
            return
        }

        try {
            worldService.save(world)
        } catch (ValidationException e) {
            respond world.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'world.label', default: 'World'), world.id])
                redirect world
            }
            '*'{ respond world, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        worldService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'world.label', default: 'World'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'world.label', default: 'World'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
