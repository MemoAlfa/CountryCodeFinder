# CountryCodeFinder challange describtion
Country Code Finder Web Service interview Challange

Please write a web application and send it back as zip file:<p>
1. which waits for a user action, e.g. clicking buttons. According to these actions some data (see further below) should be:
2. shown nicely formatted on the screen
3. downloaded as CSV file<p>

You can either download the data on each request during the runtime of your program or load the data from a database (in this case do NOT provide a DB dump, but a script which automatically transfers the data from the remote location to the DB)<br>
preferably the implementation should be written in "clean code", separate concerns using pattern like MVC, be object oriented, very good testable, best even already contain Unit tests and maybe even follow the KISS and SOLID principles
 
the data should be a list of countries with their country code
Please download the base data from http://pastebin.com/raw.php?i=943PQQ0n

# Solution
I was tempted to use django-python, then I
decided to use java with spring,hsqldb for virtual
sql database and vaadin that makes front-end
developments extremely fast.<p>
Upon running the server the dataset will be
downloaded, parsed and presisted only once.
I also wanted to include AOP with SpringAop,
but since the challenge only mentioned separate
concern not cross-cutting concern I was
reluctant.<p>
About the projcet infrastructure choice, I wanted
it to KISS as much as possible, except when it
came to modularity and scalability so I chose to
cut the layers of the app into seperate modules
included in an agregator module, through my
experience It helped a lot when different
individuals of the team work on specific layer of
the app, every module would have its own tests,
helps the spead of running maven goals, and
keeps poms clean.<p>
Most of the unit tests are in the service layer
module in the sevice module
As for the UI I kept it effective, responsive and minimal
