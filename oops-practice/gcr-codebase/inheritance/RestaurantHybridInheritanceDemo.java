public class RestaurantHybridInheritanceDemo {
    interface Worker {
        void performDuties();
    }

    static class Person {
        private String name;
        private int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void displayPerson() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
        }
    }

    static class Chef extends Person implements Worker {
        Chef(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Chef prepares meals and manages the kitchen");
        }
    }

    static class Waiter extends Person implements Worker {
        Waiter(String name, int id) {
            super(name, id);
        }

        @Override
        public void performDuties() {
            System.out.println("Waiter serves customers and manages tables");
        }
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Arjun", 201);
        Waiter waiter = new Waiter("Meera", 202);

        chef.displayPerson();
        chef.performDuties();

        waiter.displayPerson();
        waiter.performDuties();
    }
}
