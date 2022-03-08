# Huffman Coding User Interface
This is a user interface for a Java desktop application, the application that would apply Huffman Coding.

# Huffman Coding
Huffman coding is a lossless data compression algorithm. The idea is to assign variable length codes to input characters; lengths of the assigned codes are based on the frequencies of corresponding characters. The most frequent character gets the smallest code and the least frequent character gets the largest code.
The variable-length codes assigned to input characters are Prefix Codes, means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not prefix of code assigned to any other character. This is how Huffman Coding makes sure that there is no ambiguity when decoding the generated bit stream.

In this project I used JavaFX For User Graphical inteface. This project is built as an assignment for Algorithm course.

# Running the project 
This is only the user inerface used so in order to run the project, needs the JavaFx library to be build on the projecet path. 

# File format
File format could be anything, the applicaction must be able to compress any type of file. 

# Programms versions
javafx.version=17.0.1,  
Java.version=17.0.8

# Screenshots of Application

Home screen asks the user to browse for a file in order to be compressed or decompressed:

![1](https://user-images.githubusercontent.com/65151701/157238820-8dc6ad4d-afd4-498d-9656-f1076f276f19.png)

User screen to emply that the file was ready to be processed and nothing was wrong with reading the file:

![2](https://user-images.githubusercontent.com/65151701/157238833-b33c3db7-64ec-46dd-b24e-a838326a0d23.png)

Screen to ask what options does the user want to do with the file uploaded:

![3](https://user-images.githubusercontent.com/65151701/157238849-55b21e56-f34e-4bdf-9a33-080b47ff8e7e.png)

Screen user to update the user for the file state to be downloaded: 
either it's compressed:

![4](https://user-images.githubusercontent.com/65151701/157238885-bcda57ae-c5bd-4679-8a6c-68737a6efdaa.png)

Or decompressed: 

![5](https://user-images.githubusercontent.com/65151701/157238900-0e545c9a-6418-47ec-a8c1-ad03dfc4ad12.png)
