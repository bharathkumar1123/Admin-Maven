<html>
<head>
<title>Login</title>
<style>
    *{ FONT-SIZE: 20pt; FONT-FAMILY: verdana; }
    b { FONT-WEIGHT: bold; }
    .listtitle { BACKGROUND: #425984; COLOR: #EEEEEE; white-space: nowrap; }
    td.list { BACKGROUND: #EEEEEE; white-space: nowrap; }
    ul {white-space: nowrap;}
    ul, li {list-style: none; display: inline;}

</style>
</head>
<body>
<center>
<ul>
				<li><img style="PADDING-LEFT: 150px" src="log.png" alt=""></li>
				<li><img  src="logo.png" alt=""></li>
</ul><br /><br />

<table cellspacing=1 cellpadding=5>
<tr>
    <td class=listtitle colspan=2>Admin Login</td>
</tr>
<form action="login" method="POST" name="form">
<input type=hidden name=referer value="/">
<input type=hidden name=FAIL_URL value="http://www.yourdomain.com/login_failed.html">
<input type=hidden name=LOGOUT_URL value="http://www.yourdomain.com/logged_out.html">

<tr>
    <td class=list align=right>Username:</td><td class=list><input type=text name=username></td>
</tr>
<tr>
    <td class=list align=right>Password:</td><td class=list><input type=password name=password></td>
</tr>
<tr>
    <td class=listtitle align=right colspan=2><input type=submit value='Login'></td>
</tr>
</form>
</table>
</center>
</body>
</html>
