default: Driver.java Room.java Characters.java
	javac Driver.java Room.java Characters.java Interactable.java

run: Room.java Characters.java  Interactable.java
	java Driver

clean:
	rm -f *.class