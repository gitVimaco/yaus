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
    <g:form controller="shortener" action="shorten">
        <div class="box">
            <g:field type="text" name="url" class="textbox" autofocus="true" required="required" />
            <g:submitButton name="${message(code: 'yaus.shorten')}" class="button"/>
            <g:hasErrors bean="${link}">
                <ul>
                    <g:eachError var="err" bean="${link}">
                        <li>${err.field}</li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
        </div>
    </g:form>
</body>
</html>