<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:message code="yaus.title" /> - <g:message code="yaus.description" /></title>
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>

<body>
<h2><g:message code="yaus.stats" /></h2>
<div class="box">
    <table>
        <thead>
            <tr>
                <g:sortableColumn property="link.url" titleKey="yaus.longLink" />
                <g:sortableColumn property="visitCount" titleKey="yaus.visitNumber" />
                <g:sortableColumn property="link.id" titleKey="yaus.shortLink" />
            </tr>
        </thead>
        <tbody>
            <g:each in="${visits}" var="visit">
                <tr>
                    <td>${visit[0].url}</td>
                    <td>${visit[1]}</td>
                    <td><g:encodeLink linkId="${visit[0].id}"/></td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>
</body>
</html>