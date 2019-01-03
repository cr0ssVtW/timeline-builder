package timeline.builder.details

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CharacterController {

    CharacterService characterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond characterService.list(params), model:[characterCount: characterService.count()]
    }

    def show(Long id) {
        respond characterService.get(id)
    }

    def create() {
        respond new Character(params)
    }

    def save(Character character) {
        if (character == null) {
            notFound()
            return
        }

        try {
            characterService.save(character)
        } catch (ValidationException e) {
            respond character.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'character.label', default: 'Character'), character.id])
                redirect character
            }
            '*' { respond character, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond characterService.get(id)
    }

    def update(Character character) {
        if (character == null) {
            notFound()
            return
        }

        try {
            characterService.save(character)
        } catch (ValidationException e) {
            respond character.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'character.label', default: 'Character'), character.id])
                redirect character
            }
            '*'{ respond character, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        characterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'character.label', default: 'Character'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'character.label', default: 'Character'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
