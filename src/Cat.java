public class Cat extends Animal {
    private String sound;
    private String name;

    @Override
    public String getType() {
        return "猫";
    }

    Cat(int age) {
        super(age);
    }

    Cat(int age, Sex sex) {
        super(age, sex);
    }

    Cat(int age, String species) {
        super(age, species);
    }

    Cat(int age, Sex sex, String species) {
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
