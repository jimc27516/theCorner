<!doctype html>
<html>
<head>
    <title>login</title>
</head>
<body>

login
<g:form name="login" action="login">
    this is the form<br/>
    Message:  ${message}<br/>

    <g:textField name="userName" value="${userName}" />
    <g:textField name="password" value="${password}" />
    <g:submitButton name="login" value="login" />

</g:form>

<g:link elementId="registerLink" controller="register" action="index"  >register</g:link>
</body>
</html>