package com.example.demo.design.chain;

/**
 * 责任链模式
 *
 * 为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。
 * 这种类型的设计模式属于行为型模式
 *
 * 在这种模式中，通常每个接收者都包含对另一个接收者的引用。
 * 如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
 */
public class ChainOfResponsibility {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger warnLogger = new WarnLogger(AbstractLogger.WARN);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is a info level information.");
        loggerChain.logMessage(AbstractLogger.WARN,"This is a warn level information.");
        loggerChain.logMessage(AbstractLogger.ERROR,"This is a error level information.");
    }

}

abstract class AbstractLogger {
    public static int INFO = 1;
    public static int WARN = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level == level){
            write(message);
        }
        else if (nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}

class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("InfoLogger: " + message);
    }
}

class WarnLogger extends AbstractLogger {

    public WarnLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("WarnLogger: " + message);
    }
}

class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger: " + message);
    }
}


