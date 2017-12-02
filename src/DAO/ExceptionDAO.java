package DAO;

public class ExceptionDAO extends RuntimeException {
	public ExceptionDAO(String msg , Throwable cause) {
		super(msg,cause);
	}
}
