package Singleton;

public class App {
    public static void main(String[] args) {
        //SingletonLogger s1 = new SingletonLogger(); //cannot initialise because the constructor is private!
        SingletonLogger logger = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance(); //return the same instance
        logger.log("yappa hora watashi no kachi");
        logger.log("itsudemo sore wa kawaranai");
        logger2.log("nee nande ita-ita-ita-i no yamete kurenai no");
        logger2.log("kawaichatte doushitara");
        logger.closeLog(); //if we don't close the file, log.txt will be empty -- the file is still open for writing.
        logger2.log("nong muu guilty ja pen arai mai TT"); // terminal ขึ้น stream closed
    }
}
