package event.exception;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	private LocalDateTime ldt;
	private String errormsg;
	private String validationMsg;
	
	public ErrorMessage(LocalDateTime ldt, String errormsg) {
		super();
		this.ldt = ldt;
		this.errormsg = errormsg;
	}
	
	public ErrorMessage(LocalDateTime ldt, String errormsg, String validationMsg) {
		super();
		this.ldt = ldt;
		this.errormsg = errormsg;
		this.validationMsg = validationMsg;
	}
	
	public String getValidationMsg() {
		return validationMsg;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public String getErrormsg() {
		return errormsg;
	}

}
