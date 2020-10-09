public class Dog extends Animal {
    private String sound;
    private String name;

    @Override
    public String getType() {
        return "狗";
    }

    Dog(int age) {
        super(age);
    }

    Dog(int age, Sex sex) {
        super(age, sex);
    }

    Dog(int age, String species) {
        super(age, species);
    }

    Dog(int age, Sex sex, String species) {
        super(age, sex, species);
    }

    public String getSound() {
        return sound;
    }

    public String getName() {
        return name;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setName(String name) {
        this.name = name;
    }
}
