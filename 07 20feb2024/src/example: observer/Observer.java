public interface Observer {

    void update(String msg);

}

class youtubesubscriber implements Observer{

    private String name;

    public youtubesubscriber(String name) {
        this.name = name;

    }

    public void update(String msg) {

        System.out.println(name +"received msg"+ msg);
    }
}
