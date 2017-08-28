package edu.spring.stringaop;

public class ErrorReport {

	private String methodName;
	private String exceptionName;
	public ErrorReport(String methodName, String exceptionName) {
		super();
		this.methodName = methodName;
		this.exceptionName = exceptionName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	@Override
	public String toString() {
		return "ErrorReport [methodName=" + methodName + ", exceptionName=" + exceptionName + "]";
	}
	
}
