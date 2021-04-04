package us.google.max.sir.epamtasks.third.xml.parser;

public class XMLParserException extends Exception{
    public XMLParserException() {
        super();
    }

    public XMLParserException(String message) {
        super(message);
    }

    public XMLParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLParserException(Throwable cause) {
        super(cause);
    }

    protected XMLParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
