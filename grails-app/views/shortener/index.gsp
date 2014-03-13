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
            <div>
                <g:message code="yaus.enter.url" />
            </div>
            <div>
                <g:field type="url" name="url" class="textbox" autofocus="true" required="required" />
                <g:submitButton name="${message(code: 'yaus.shorten')}" class="button"/>
            </div>
            <g:hasErrors bean="${link}">
                <div class="errors">
                    <g:eachError var="err" bean="${link}">
                         <g:if test="${err.field} == 'url"><g:message code="yaus.Link.url.invalid.url.message" /></g:if>
                    </g:eachError>
                </div>
            </g:hasErrors>
        </div>
    </g:form>
</body>
</html>