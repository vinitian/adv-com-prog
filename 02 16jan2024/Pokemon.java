public class Pokemon {
    String Name;
    int Age;
    String[] Type = new String[3];
    int Level;
    char Rarity;
    //method or function

    public Pokemon(String Name, int Age, String[] Type, int Level, char Rarity) {
        this.Name = Name;
        this.Age = Age;
        for (int i = 0; i < 3; i++) {
            this.Type[i] = Type[i];
          }

        this.Level = Level;
        this.Rarity = Rarity;
    }
    public void DisplayInfo(){
        System.out.println("Your POKEMON");
        System.out.println("*******************");
        
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        
        System.out.println("Type: " + Type[0] + ", " + Type[1] + ", " + Type[2]);
        System.out.println("Level: " + Level);
        System.out.println("Rarity: " + Rarity);
    }
    
    public static void main(String[] args) {
        /* Pokemon p1 = new Pokemon(); // creating an instance of the class (aka object) 
        p1.DisplayInfo();
        p1.Name = "Charizard";
        p1.Age = 5;
        p1.Type[0] = "Fire"; p1.Type[1] = "Flying";
        p1.Level = 90;
        p1.Rarity = 'S';
        p1.DisplayInfo(); */

        Pokemon p2 = new Pokemon("Umbreon", 300, {"Dark", "Lightning"}, 358, 'A');
        /* p1.Name = "Umbreon";
        p1.Age = 300;
        p1.Type[0] = "Dark";
        p1.Level = 358;
        p1.Rarity = 'A'; */
        // p1.DisplayInfo();

    }
}

