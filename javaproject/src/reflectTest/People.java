package reflectTest;

/**
 * Created by doshest on 2017/6/8.
 */
public class People {
    private String name;
    private Integer age ;
    private  boolean adult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public People(String name, Integer age, boolean adult) {
        this.name = name;
        this.age = age;
        this.adult = adult;
    }

    public People() {
    }
    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (adult != people.adult) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        return age != null ? age.equals(people.age) : people.age == null;

    }*/

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (adult ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adult=" + adult +
                '}';
    }
}
