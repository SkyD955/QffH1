public class Fish extends Animal {
    private String name;

    @Override
    public String getType() {
        return "鱼";
    }

    Fish(int age) {
        super(age);
    }

    Fish(int age, Sex sex) {
        super(age, sex);
    }

    Fish(int age, String species) {
        super(age, species);
    }

    Fish(int age, Sex sex, String species) {
        super(age, sex, species);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
