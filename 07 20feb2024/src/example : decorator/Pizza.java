public interface Pizza {
    public String getdescription();
    public double getcost();

}
class PlainPizza implements Pizza{

    public String getdescription(){
        return "Plain Pizza";
    }
    public double getcost(){
        return 50.0;
    }
}
