# Online Book Store Readme

Welcome to our online book store! Our website is designed to provide an easy and convenient way to buy books online. In this readme file, you will find information on how to use our website, the features we offer, and the technology stack we used to develop it.

## Features

Our website provides the following features:

### For Admin
- Add new books to the inventory
- Edit existing books in the inventory
- Remove books from the inventory
- View all books in the inventory
- View all orders placed by users

### For User
- Sell old books
- Add books to the cart
- Buy books using a payment method
- Remove items from the cart
- Edit user profile information
- View Details of the books
- Help Center service

## Technology Stack

Our website is developed using the following technologies:

- Java
- Servlet
- JSP
- JSTL
- JDBC
- HTML
- CSS
- JavaScript
- MySQL
- Tomcat Apache 9.0
- Maven
- Eclipse
# Website Home page​

1> Home Page : In this page we can see only four new books and four old books for viewing all books just click view All button. Anyone can access this page using URL but they can't add any book to the cart until they are login. We can search the books also​

![homepage](https://user-images.githubusercontent.com/43900397/234164759-f8812ad3-9d8a-4cd5-aa56-fa32590859b1.png)
2> Login: User are allowed to login if they are already register otherwise message shows up "user are not registered please register".​
Admin can also login using their email and password.
![login](https://user-images.githubusercontent.com/43900397/234164992-887f06af-b86c-4fc0-af6d-11e4ba6ac186.png)

3> Register: User can register themselves and then only can login to the site if they are already register message shows up "user is already registered ".​
![register](https://user-images.githubusercontent.com/43900397/234165067-3c95abf0-60d7-4cc4-9cec-03e5e03bdf5f.png)

# Administration Module​
1> Home Page : Admin can add new books , view all books , edit all books, view all ordered books and logout.​
![adminControls](https://user-images.githubusercontent.com/43900397/234165216-3a16f523-c3de-4ce5-b62c-2d562361a116.png)
2> Add Books : Admin can add new books , by filling the below details.​
![addBooks](https://user-images.githubusercontent.com/43900397/234165316-a3bdc085-8609-4d9f-9f10-0ef4b2977e49.png)
3> View All Books : Admin can view All books present in the database.​
![AdminAllBooksLookOut](https://user-images.githubusercontent.com/43900397/234165399-0671d2ae-531b-4b85-9d9a-e91102f08798.png)
4> Edit Books : Admin can view All books and edit or delete them.​
![edit books](https://user-images.githubusercontent.com/43900397/234165457-9f1aa99f-6eb4-4c0e-a7ca-135d1d1c5a50.png)

# User Module​
1> Home Page : User can add any books to the cart , view all books , view their ordered  books and buy books .​
![userHome page](https://user-images.githubusercontent.com/43900397/234165557-263c0d83-a4ad-42f5-8072-0eacf9425fde.png)
2>All New Books Page : All new Books show here.​
![All new Books](https://user-images.githubusercontent.com/43900397/234165632-b4572d32-8c03-41c3-9fa9-bce6cb747bf1.png)
3> Settings: User can sell Old books , Edit their profile , view their ordered books and take help using service center.​
![Settings](https://user-images.githubusercontent.com/43900397/234165690-381a239d-e601-4fb2-a7f4-28c88b6e1b17.png)
4>Sell Old Books : User can sell Old books by inserting the below details.​
![sell Old Books](https://user-images.githubusercontent.com/43900397/234165767-ab7e4b1e-9c9b-4379-8d0e-688db226ca80.png)
5>Edit profile : User can edit their profile details by inserting the below details.​
![edit profile](https://user-images.githubusercontent.com/43900397/234165846-ae14f61f-beaa-4901-aed0-32658a32bed2.png)
6> My Orders: User can ordered books of theirs using my Order button​
![UserMy Orders](https://user-images.githubusercontent.com/43900397/234165886-196dc5e6-eb92-45eb-a43e-6223c619cc31.png)
7> Help Center : In this section, we have provided the contact number and proper address so that customers and shopkeepers can reach us and mentioned their problems to solve if there is any technical issue related to their login and log out.​
![contactUs](https://user-images.githubusercontent.com/43900397/234165942-a4c4e029-ebdb-4266-a37b-e37c015a3df8.png)
8> View Book Details: User can view details of any books available and add them to cart from there only.​
![view Details](https://user-images.githubusercontent.com/43900397/234166008-328eb1a7-7c72-4d4e-a8ba-25e06264dbc2.png)
9> Cart: User can add books to the cart and they can also remove them . For ordering click the order now button.​
![cart](https://user-images.githubusercontent.com/43900397/234166038-492cd3c0-db2b-492e-923a-d2f2abb796ae.png)
10> Order placed : After successful order message is given to user about the delivery.​
![order_success page](https://user-images.githubusercontent.com/43900397/234166113-8c67cf18-48e8-4ba8-ab81-6210813172eb.png)



## Getting Started

To use our website, please follow these steps:

1. Clone the repository to your local machine.
2. Import the project into Eclipse using Maven.
3. Set up a MySQL database and create the necessary tables (user, book_details, book_order , cart).
4. Update the database configuration in the `application.properties` file.
5. Run the project on a local server.



Thank you for choosing our online book store!
