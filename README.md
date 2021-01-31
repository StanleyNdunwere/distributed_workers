# distributed_workers
A Demo application simulating distributed workers

## Setting Up The Application
To access this application; clone the repository and pull the required libraries using an IDE (Preferably Intellij IDEA).
The application uses a MySql database instance to store the jobs. For the purpose of development I configured the application to read from the database on my local machine.
You will need to configure the application to connect to your own MySql instance.
The configuration is present in the application.properties files located in the root of the resources folder. If properly configured Springboot will start indexing the application without errors.
Once the IDE completes indexing the application you can run it via the run button at the top right corner of your screen (Intellij IDEA) or using Ctrl + f5.

## Navigating the Application
As soon as the application boots up, go to the browser and navigate to the URL where springboot is serving the application. i.e 
localhost:8080

This should bring up a page that with pre-seeded jobs listed on a table.

![Distributed workers homepage](https://i.ibb.co/fSxFgbX/distributed-workers.jpg)
Below this table there are three buttons to simulate parallel execution of the distributed workers.
Clicking on them will fire requests to the springboot application to initiate processing of the jobs.
Due to the speed of completion I added an artificial delay of 2 seconds to allow for better appreciation of the parallel execution of the jobs.

## Processing
You should see real-time updates on the screen as each jobs complete.
The top-most section of the page just below the header shows the number of jobs completed per processor
The table holds the job status and changes them in real time as each job progresses from NEW to PROCESSING and finally to DONE/ERROR stages.

