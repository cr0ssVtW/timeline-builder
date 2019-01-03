package timeline.builder.details

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CityController {

    CityService cityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cityService.list(params), model:[cityCount: cityService.count()]
    }

    def show(Long id) {
        respond cityService.get(id)
    }

    def create() {
        respond new City(params)
    }

    def save(City city) {
        if (city == null) {
            notFound()
            return
        }

        try {
            cityService.save(city)
        } catch (ValidationException e) {
            respond city.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'City'), city.id])
                redirect city
            }
            '*' { respond city, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cityService.get(id)
    }

    def update(City city) {
        if (city == null) {
            notFound()
            return
        }

        try {
            cityService.save(city)
        } catch (ValidationException e) {
            respond city.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'city.label', default: 'City'), city.id])
                redirect city
            }
            '*'{ respond city, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'city.label', default: 'City'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
