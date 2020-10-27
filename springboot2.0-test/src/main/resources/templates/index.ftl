<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title>freemarker</title>
</head>
<body>
${name}

<#if sex=="1">
    男
<#elseif sex=="2">
    女
<#else>
    其他

</#if>
<#list nameList as user>
    ${user}
</#list>


</body>
</html>
