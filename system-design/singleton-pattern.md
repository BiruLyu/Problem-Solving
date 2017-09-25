# Singleton Pattern

- The **singleton pattern** is a software design pattern that restricts the instantiation of a class to one object. 
  The singleton pattern ensures that a class has only one instance and the sole instance of the class can be accessed easily.

- This is useful when exactly one object is needed to coordinate actions across the system.

- ==Implementation==

  - Hide the constructor of the class by declaring all constructors of the class to be private.

  - privode global access to that instance by defining a public static operation (`getInstance()`) that returns the sole instance of the class.

  - ```java
    public final class Singleton {
        private static final Singleton INSTANCE = new Singleton();

        private Singleton() {}

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
    ```

  - ### Lazy initialization

    ```java
    public final class Singleton {
        private static volatile Singleton instance = null;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized(Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    ```

    Using **double-checked locking** guarantees the class is thread-safe. 

    ​

> Referenced Links
>
> [Singleton Pattern from Wikipedia](https://www.wikiwand.com/en/Singleton_pattern) 

