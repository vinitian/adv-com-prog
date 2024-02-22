public class App {
    public static void main(String[] args) throws Exception {
        
        // create subject : creating youtube channel
        youtubechannel Subject = new youtubechannel();

        // create subscribers for the channel
        Observer ob1= new youtubesubscriber("Alex");
        Observer ob2 = new youtubesubscriber("Cathelin");
        Observer ob3 = new youtubesubscriber("Jack");

        
        Subject.registerObserver(ob1);
        Subject.registerObserver(ob2);
        Subject.registerObserver(ob3);
        //Subject.removeObserver(ob1);

        Subject.setmessgae("Hello SUbscribers");
    }
}
