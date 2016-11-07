<!doctype html>
<html>
<head>
    <title>RegisterView</title>
</head>
<body>

    <g:form name="registerPerson" action="registerPerson">
        this is the form
        <g:textField name="userName" value="${userName}" />
        <g:textField name="password" value="${password}" />
        <g:textField name="firstName" value="${firstName}" />
        <g:textField name="lastName" value="${lastName}" />
        <g:textField name="favoriteFruit" value="${favoriteFruit}" />
        <g:submitButton name="registerPersonButton" value="Register" />

    </g:form>

</body>
</html>