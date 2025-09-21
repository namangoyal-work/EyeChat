## EyeChat
                                                      EyeChat
                          Building a community conscious computer vision algorithm that aids
                                     in input methods for the differently abled.


### Abstract
				              			
The projects’ main aim was to develop a computer vision algorithm that assists in input methods by detecting the state of an object in a digital frame after initial training with use of a video capturing device.
The project works on the fundamental concepts of creating a solution for real world problems that are constantly faced in the 21st century. Recording data using methods that assist the differently abled, by allowing them to input data at the “blink of an eye” ,the algorithm helps in controlling, manipulating and inputting data to a machine.
The algorithm also bridges the gap between technology and difficulties faced by people in using these technological advances and helps by being incredibly user-friendly in the above mentioned situations. In addition, It serves the bigger purpose of solving real life problems rather than creating something superficial.

### Hypothesis
							
Using a Video capturing device and given algorithm-software interface, input can be provided by an eye-blink. This input can be stored successfully and actions on this input can be performed.

### Platforms used
OpenCV <br>
Python <br>
Java

### Procedure

The program uses Haar Cascades to find the location of eyes in the image and then once the given area is found, we use an algorithm to detect the state of eyes. The algorithm first identifies Regions of Interest in this area. This done so as to maximize difference in mean value of individual color channels and make detection more accurate. Then in these regions of interest, RGB values of pixel in the given area and takes average and are compared to training data to find whether eyes are open or close.

### Approaches and problems
		            				     
The following section of the report talks about the above mentioned materials and then dwells deeper into their usage in their development of the program and problems faced at each juncture. 

#### OpenCV:
We use OpenCV for interfacing to the Web Camera and for using Haar Cascade to find the location of the eyes within the captured frame. We use nested cascades, a primary cascade to find where the face is in the image and then within this area, we use the secondary cascade of eyepair to find where the eye is. This approach solves the problem faced earlier where there were cases of erroneous detection of eyepair in the frame. The lack of prior knowledge about Haar Cascade methods also made the job difficult in the beginning. 
Getting image frames from the web camera was the easiest of all the issues that came up with this library. All we had to was tell the channel no of the web camera we want to read frames from and the OpenCV library would return an object which would let us read from the webcam and return a three dimensional array with different 2D arrays for the R, G and B channels.


#### Python:
We use python to implement the algorithm and make necessary interactions with the OpenCV library. There were a lot of complex math operations involved for the initial training ranging from matrix operations to probability. The matrix operations were required mostly for training purposes since the images were 3D NumPy arrays and it took some time for us to wrap our brains around the inner workings of the same. Finally, we wrote object oriented code for all the methods required for the process of training and recognition. We made the initialization method and the two detection methods. We then created an object of the above OOPs class. We also implemented sockets in python to send state data from python to java.


#### Java:				              
Java was used extensively in designing the GUI section of the project. The basic idea behind the GUI was to create a user friendly interface that facilitates in easy acceptance of data input. During our preliminary designing, we began working on JFrames and Java Swing class. The initial idea was to design a n by m size matrix containing the  26 alphabets of the English language,  all the ten digits from 0-9, and a few more basic functionalities. Soon after initiation we realised that the problem at hand was slightly more severe than we had anticipated it to be. Our first obstacles was while designing the initial layout. The GUI works in the following manner:
As the GUI runs , it displays the entire matrix of options in the keyboard on the screen. The array is hidden from the screen after 5 seconds. Then at each juncture of 2 seconds, it starts displaying the individual columns, first the first column and then the next and so on until the user blinks. At this point the value of the column is recorded and the column freezes on the screen and then moves iteratively throughout the row elements inside that column. Again the program captures the value once a blink is recorded. This value is then concatenated to the “Text Entered: ” field at the top of the JFrame.
The initial problem we faced while working on this aspect was struggling with the Thread.Sleep() function and Timer() function. The JFrame would not change state as required after an initial delay, and would end up freezing on the screen, hence defeating the whole purpose of the proposed GUI. Thread.sleep() is done on the Event Dispatch Thread which will lock the GUI. Also, the code required that no JButtons be used and hence we had to abstain from using the ActionListener() and ActionPerformed() functionalities. After initial problems, a fix was figured out and was implemented. The fix uses the System.currentTimeMillis() function from java.lang package to record time at a particular instant and then compare it with the time recorded at some previous point to bring about changes in the JFrame.


#### Socket Programming:					           
Once the implementation of the above was figured out , the remaining section of GUI was worked on. The next part of the GUI was implementing Sockets using TCP between the Python backend and Java GUI. The problem with the socket programming was the lack of prior knowledge. However, by understanding the concept and referring to a few samples codes online a basic idea of the process was developed. Then a sample program was written to connect the Python  client with the Java server. The Socket programming basically bridged the gap between the GUI and the Python code by facilitating an easy input-output medium.

  
Once the three different aspect of the project were successfully developed, we began with the pilot testing phase. We trained our algorithm with multiple scenarios (light intensity, various eye structures, various hypothetical eye blink frames). The results of these tests are expanded on in the following section. 

### Results        
The Algorithm follows a pattern when implemented. It starts off with a training section where the eye state of the user is recorded and compared for open and closed state values. Once successfully recorded, it prompts the GUI to appear and start functioning. After this the GUI works relatively smoothly and we are able to seamlessly input data using our eyes.

Though finally successful, a lot of problems were faced and then fixed in the due course of this project development.
Light intensity resulted in various erroneous data. 
Initial training of the algorithm was time consuming to reach a good accuracy rate.
The latency of the GUI and Python code lacked initial calibration, resulting in erroneous values.  

One of the way we fixed the problem was by holding intensive training sessions , constantly providing test cases to the algorithm and fixing any issues. A few errors were found that were resolved and the program was finally brought to the working stage. After this, acceptable results were recorded.

### Conclusion

In a time when technology is perhaps the centre of all of existence, it should not be provided just to those who can afford it but to those who also need it. And that is what our project has successfully achieved. It bridges this gap and provides to people who are unable to use technology in its conventional form, a user friendly alternate at data input by providing a inclusive human-computer interface.

### References
http://www.ebenezertechs.com/instalar-opencv-2-4-13-en-ubuntu-14-04-y-16-04/
<br>
https://en.wikipedia.org/wiki/Locked-in_syndrome

