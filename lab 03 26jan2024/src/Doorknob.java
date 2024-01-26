
public class Doorknob {
    private String doorknobID;

    public Doorknob(String doorknobID) {
        this.doorknobID = doorknobID;
    }

    public boolean canUnlock(Key key) {
        if (this.doorknobID.equals(key.getKeyID())) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getDoorknobID() {
        return doorknobID;
    }

}
