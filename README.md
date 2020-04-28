# 594-Final-Project

1. Additional Feature

For all the zipcodes user has provided, the additional feature of the Processor analyzes the data and ouputs the zipcode with the highest, lowest, and median residential market value per capita and its corresponding fines per capita. The feature uses all three input data sets, as it contains per capita information for both residential properties and parking fines. 

We tested various user inputs and confirmed its correctness by comparing its result with the result from step 2 and step 5 of the project instruction. 

2. Use of Data Structures

1) We used HashMap heavily in the program, as we need to store key value pairs where the key is the zip code and the value is relevant information such as population, parking fines, and property value. The HashMap enables us to quickly retrieve these data in O(1) time. Alternative data structures including Lists and Sets take O(n) time to find a particular zipcode and its relevant data. 

2) In Parking Processor, we used the TreeMap data structure. The reason for using a TreeMap is that we need to arrange zipcodes in ascending order. In Java, TreeMap is implemented as a Red-Black Tree. Maintaining the sorted order takes O(logn) time for each insertion. The alternative is to use an unsorted data structure when we add data, and then sort it before we output the result. Sorting itself takes O(nlogn) time, and it also requires a separate step for sorting. TreeMap removes the need to sort the data separately, as it always maintains sorted order when new data is added.  

3) In Properties data, we used an ArrayList as the 'value' in the HashMap where the zipcode is the 'key'. The reason we need a separate data structure as 'value' is we need to store more than one property information for each zipcode. Alternative data structures are Sets or LinkedList. We thought ArrayList is easiest as it takes O(1) time to retrieve the info we need. 
