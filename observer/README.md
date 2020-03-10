# Observer, a behaviour design pattern

Software application needs to update a set of objects when another object has some changes. The set of objects are the observers. The another object is the observable.

Implementation steps:

1. In 'java.util' package, Observer is an interface and Observable is a class;

2. Your observer class must implement the Observer interface;

3. Your observable class must extend the Observable class;

4. In your observer class, you have to override the "update()" method. This method is used to keep the observers updated if there is some change in the observable object.

In your observable class, you have to: 

5. create a method that informs if there is changes in the observable object (e.g. setChanged());

6. create a method that notifies the observers that there are changes (e.g., notifyObservers());

7. after notifying the observers, the observable object must have a new status: there is no change from the last notification;