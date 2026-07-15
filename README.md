### Task A.

---
#### Create a new Java project using Spring Initializr, with each of the following dependencies:

- Spring Data JPA (spring-boot starter-data-jpa)
- Rest Repositories (spring-boot-starter-data-rest)
- MySQL Driver (mysql-connector-java)
- Lombok

_Note: Since the application properties will be empty, you will need to copy over the supplied application properties._

### Task B.

---
#### Create your subgroup and project by logging into GitLab using the web link provided and do the following:
- connect your new Java project
- commit with a message and push when you complete each of the tasks listed below (parts B to F, etc.)

_Note: Any submissions that do not have a commit after each task will not be evaluated._

_Note: You may commit and push whenever you want to back up your changes, even if a task is not complete._

- Submit a copy of the git repository URL and a copy of the repository branch history retrieved from your repository, which must include the commit messages and dates.

_Note: Wait until you have completed all the following prompts before you create your copy of the repository branch history._

### Task C.

---
#### Construct four new packages, one for each of the following: controllers, entities, dao, and services. The packages will need to be used for a checkout form and vacations packages list.

_Note: The packages should be on the same level of the hierarchy._

_Note: Construct a package named config and copy the RestDataConfig.java provided in the laboratory environment to the package. Modify it so that the package and imports have the correct package and import addresses. Copy the application.properties file that is provided in the laboratory environment into your application properties resource file._

1. Created packages for controllers, dao, and services. Entities and config packages were previously created along with RestDataConfig.java and application.properties file.

### Task D.

--- 
#### Write code for the entities package that includes entity classes and the enum designed to match the UML diagram.
1. Added code for entity packages that includes entity classes and enum.
2. Added missing column names in `Customer.java`

### Task E.

---
#### Write code for the dao package that includes repository interfaces for the entities that extend JpaRepository, and add cross-origin support.
1. Created repository interfaces for entities that extend JpaRepository and added cross-origin support.

### Task F.

---
#### Write code for the services package that includes each of the following:

- a purchase data class with a customer cart and a set of cart items
- a purchase response data class that contains an order tracking number
- a checkout service interface
- a checkout service implementation class

1. Created a purchase data class.
2. Created a purchase response data class.
3. Created a checkout interface.
4. Created a checkout service implementation class.

### Task G.

---
#### Write code to include validation to enforce the inputs needed by the Angular front-end.

1. Added validation to `Customer.java` enforce the inputs needed.
2. Minor updates to `CheckoutServiceImpl`.

### Task H.

---
#### Write code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders.

_Note: You do not need to duplicate REST functionality for each repository by creating methods in Java._

1. Created controller package that includes a REST controller `Checkoutcontroller.java` class with a post mapping to place orders.
2. Updated "cartItem" to "cartItems" in Cart class on `Cart.java`.
3. Minor changes to `CheckoutServiceImpl` for readability.
4. Added "CascadeType.ALL" to carts on `Customer.java`.
5. Updated "cartItem" to "cartItems" in Purchase class on `Purchase.java`.

### Task I.

---
#### Add five sample customers to the application programmatically.

_Note: Make sure the customer information is not overwritten each time you run the application._

### Task J.

--- 
#### Run your integrated application by adding a customer order for a vacation with two excursions using the unmodified Angular front-end. Provide screenshots for the following:

- that your application does not generate a network error when adding the data
- your database tables using MySQL Workbench to show the data was successfully added


_Note: The screenshot should include the front-end view and the inspection console in the browser._

### Task K.

---
#### Demonstrate professional communication in the content and presentation of your submission.
