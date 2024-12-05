<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Todo</title>
</head>
<body>
    <h1>Add Todo Item</h1>
    <form action="AddTodo" method="post">
        <label for="google_account">Google Account:</label><br>
        <input type="text" id="google_account" name="google_account" required><br><br>

        <label for="todo_startdate">Start Date:</label><br>
        <input type="text" id="todo_startdate" name="todo_startdate" required><br><br>

        <label for="todo_deaddate">Deadline:</label><br>
        <input type="text" id="todo_deaddate" name="todo_deaddate" required><br><br>

        <label for="todo_memo">Memo:</label><br>
        <textarea id="todo_memo" name="todo_memo"></textarea><br><br>

        <label for="todo_file_path">File Path:</label><br>
        <input type="text" id="todo_file_path" name="todo_file_path"><br><br>

        <label for="is_important">Is Important:</label><br>
        <select id="is_important" name="is_important">
            <option value="0">No</option>
            <option value="1">Yes</option>
        </select><br><br>

        <input type="submit" value="Add Todo">
    </form>
</body>
</html>