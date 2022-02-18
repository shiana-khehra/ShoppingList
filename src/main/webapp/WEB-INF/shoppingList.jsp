<%-- 
    Document   : shoppingList
    Created on : Feb 14, 2022, 9:15:51 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello, ${name} <a href="">Logout</a></p>
        
        <h2>List</h2>
        
        <form>
            <label for="item">Add item: </label>
            <input type="text" id="item" name="item">
            <button type="submit">Add</button>
        </form>
        
        <form>
            <p>
            <input type="radio" name="items" value="apples">
            apples
            </p>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
