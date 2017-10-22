# StringPanel
If you run the code in the project you will see the word "runnable" in red moving off to the lower right and then off the screen.
The class extends JPanel (meaning it is a copy that can be modified) and it implements the Runnable interface.
The paintComponent() method belongs to the JPanel class which is why it has @Override before it.
The run() method has to be implemented by us if we implement the Runnable interface. That's why it has @Override before it.
Inside the run() method we have an infinite loop that sleeps for 60 milliseconds and then calls the paintComponent() method.
You can change the string to whatever you want as long as it has at least 8 letters.
Your task is to do the following:
  When the word hits the right wall
    1) the word should change color
    2) the variable wordVx should change to a random value between -3 and -8
    3) the last letter of the word should move to the front of the word
  when it hits the bottom wall
    1) the word should change color
    2) the variable wordVy should change to a random value between -5 and -10
    3) the middle letter of the word (at index word.length() / 2) should be doubled
    (i.e. the word runnable has length = 8 and the letter at index 4 is "a" so runnable -> runnaable)
  when it hits the left wall
    1) the word should change color
    2) the variable wordVx should change to a random value between 4 and 7
    3) the first letter should move to the center of the word and the second letter should move to the end
  when it hits the top wall
    1) the word should change color
    2) the variable wordVy should change to a random value between 2 and 11
    3) the letters at index word.length() and word.length() + 1 should be removed as long as word.length() > 1
