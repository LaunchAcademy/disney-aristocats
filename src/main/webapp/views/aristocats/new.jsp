<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Aristocats</title>
  </head>
  <body>
    <form action="/aristocats" method="post">
      <div>
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" />
      </div>
      <div>
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" />
      </div>
      <div>
        <label for="photoUrl">Photo URL</label>
        <input type="text" name="photoUrl" />
      </div>

      <input type="submit" value="Add Aristocat!" />
    </form>
  </body>
</html>