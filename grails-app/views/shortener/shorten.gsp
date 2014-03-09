<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:message code="yaus.title" /> - <g:message code="yaus.description" /></title>
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>

<body>
    <h1><g:message code="yaus.title" /></h1>
    <h2><g:message code="yaus.description" /></h2>
    <div class="box">
        ${link.url} : <g:encodeLink linkId="${link.id}"/>
    </div>
</body>
</html>