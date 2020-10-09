public abstract class Animal implements Comparable<Animal> {
    private int age;
    private String species;
    private Sex sex;

    public abstract String getType();

    Animal(int age) {
        this.age = age;
    }

    Animal(int age, Sex sex) {
        this.age = age;
        this.sex = sex;
    }

    Animal(int age, String species) {
        this.age = age;
        this.species = species;
        this.sex = new Sex("雄");
    }

    Animal(int age, Sex sex, String species) {
        this.age = age;
        this.species = species;
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(this.age, o.getAge());
    }
}
