package event;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import event.exception.AdminException;
import event.exception.ErrorMessage;
import event.exception.ProductException;
import event.exception.UserException;


@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(AdminException.class)
	public @ResponseBody ErrorMessage checkAdminException(AdminException ae) {
		ErrorMessage msg=new ErrorMessage(LocalDateTime.now(),ae.getMessage());
		return msg;
	}
	
	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorMessage checkUserException(UserException ue) {
		ErrorMessage msg=new ErrorMessage(LocalDateTime.now(),ue.getMessage());
		return msg;
	}
	
	@ExceptionHandler(ProductException.class)
	public @ResponseBody ErrorMessage checkProductException(ProductException pe) {
		ErrorMessage msg=new ErrorMessage(LocalDateTime.now(),pe.getMessage());
		return msg;
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ErrorMessage checkBookValidation(MethodArgumentNotValidException me) {
		ErrorMessage msg=new ErrorMessage(LocalDateTime.now(),me.getMessage(),me.getBindingResult().toString());
		return msg;
	}
}
