import com.store.exception.InvalidProductTypeException
import com.store.model.ErrorResponseBody
import jakarta.servlet.http.HttpServletRequest
import java.time.LocalDateTime
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidProductTypeException(
        ex: InvalidProductTypeException,
        request: HttpServletRequest
    ): ErrorResponseBody {
        return ErrorResponseBody(
            timestamp = LocalDateTime.now().toString(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = ex.message ?: "Invalid product type",
            path = request.requestURI
        )
    }
}
