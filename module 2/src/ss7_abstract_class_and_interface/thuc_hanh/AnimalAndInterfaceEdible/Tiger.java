package ss7_abstract_class_and_interface.thuc_hanh.AnimalAndInterfaceEdible;

public class Tiger extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return null;
    }
}
