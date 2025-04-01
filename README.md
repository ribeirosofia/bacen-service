<h1 align="center">Bacen Service Aplication</h1>

<p align="center">This program is being developed to test habilities in Java.</p>

<p>To initialize the project it's important to create the project clicking in the following link:</p>

<ul>
  <li><a href="https://start.spring.io/">Start Spring Link</a></li>
</ul>

<p>For sprint Boot, you can create it in 3.4.4 version, package jar, Java 17.</p>

<p>The dependencies used for the project are the following ones:</p>

<ul>
  <li><code>Lombok</code></li>
  <li><code>H2 Database</code></li>
  <li><code>Spring Data JPA</code></li>
  <li><code>Spring Web</code></li>
</ul>

<p>Generate the project, download and unzip it into your choosen folder.</p>

<p>Make sure your JDK is setted to Java 17</p>

<p>Open the Project with your choosen IDE. I am currently using Intellij IDEA Community.</p>

<p>To initally run the application, use the following command line:</p>

<ul>
  <li><code>mvn clean install</code></li>
</ul>

<p>Make sure to initialize and push your application to github.</p>

<p>Create the model package inside main > java > com.bootcamp.bacen_service folder. Then, create the <code>Key</code> class.</p>

<p>Create the repository package inside main > java > com.bootcamp.bacen_service folder. Then, create the <code>KeyRepository</code> interface.</p>

<p>Create the dto package inside main > java > com.bootcamp.bacen_service folder. Then, create the <code>KeyRequestDTO</code> class and <code>KeyResponseDTO</code> class.</p>

<p>Create the service package inside main > java > com.bootcamp.bacen_service folder. Then, create the <code>KeyService</code> class.</p>

<p>Create the file inside main > resources names <code>application.yaml</code> </p>

<p>Create the controller package inside inside main > java > com.bootcamp.bacen_service folder. Then, create the <code>KeyController</code> class.</p>


<p>Test the aplication using Postman and the H2 database.</p>

<p>To test on H2, use the following link: http://localhost:9002/h2-console/</p>

<p>To run the application correctly, edit the jdbc url to:  <code>jdbc:h2:file:./data/bacen_service</code>, change <code>user</code> to <code>admin</code> and <code>password</code> to <code>admin</code></p>

<!-->Insert Chave table to guide the user</!-->

<p>Run the application on Postman, do your login, click in the button Collections, + to create a new collection. Rename it to bacen-service</p>

<p>Do the post method on Postman to test the application using the following link: http://localhost:9002/api/bacen/chaves</p>

<p>Set the Body to raw(JSON) and write the following object:</p>

<code>
{
 "chave": "chave1",
 "ativa": true
}
</code>

<p>Click in "Send". It will generate a 201 http status.</p>

<p>Do the get method on Postman to test the application using the following link: http://localhost:9002/api/bacen/chaves/{value-of-chave} (In my case, the value of chave was chave1, so the path needs to be chave1)</p>

<p>Click in "Send". It will generate a 201 http status and return the following code:</p>

<code>
{
 "chave": "chave1",
 "ativa": true
}
</code>
