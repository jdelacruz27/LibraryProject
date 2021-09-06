#Sparta Library Project

A system that simulates a library and does the following:
- A database that hold details on books (ISBN number, title, author, genre).
- A user will be able to log into the system and search for books by genre, title and author.
- A user will be able to rent a book out.Once this is done, the book will not be visible to any other user. This book 
  will remain out until it is returned by the user.
  
- An admin will be able to login and create new books and users. They can also remove book and authors.

This system is created in Springboot with spring security, JPA, MySql, JavaScript and HTML.

#User Guide
Once a connection has been made to a Mysql database schema, in the LibraryProjectApplication class in
the directory of src/java/com.sparta.jian.libraryproject a new user object that has an ADMIN role
to have full control of the website needs to be created. This user will be saved in the database and will allow access
to the website.

When logged in as an admin, the admin can create new books, author and genres. When creating a new book, the admin
can enter the ISBN number and title but will need to select an Author and genre from a drop down list. The drop down list
is connected to the author table and genre table. It is advised to create a new author and genre, if it does not exist yet,
before creating a new book. Edits can be made to books, authors and genres and the can also be deleted. The admin can also 
view all the books, author and genre in the system. New users can also be made, assigning them passwords and roles. 
Admins can change their password and roles whenever they wish. 

When logged in as a user, the user has only access to the books that can be rented and the books they have rented. They
cannot make changes to data of the books, authors and genre. The user has the ability to search for a book through the use
of the search bar.