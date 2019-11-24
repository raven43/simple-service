<#macro page title selected_tab="">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/main.css" type="text/css">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <script rel="script" type="application/javascript" src="/static/main.js"></script>
</head>
<body class="bg-secondary">
<@header selected_tab></@header>
    <main class="bg-white card mx-auto pb-3" style="max-width: 720px">
        <#nested>
    </main>
</body>
</html>
</#macro>
<#macro header selected_tab="">
    <header class="navbar-dark   bg-dark mb-3">
        <nav class="navbar navbar-expand-md  mb-3 mx-auto" style="max-width: 820px">
            <a class="navbar-brand" href="/">Simple Service</a>
            <div class="navbar-nav">
                <a class="nav-item nav-link ${(selected_tab=="home")?string("active","")}" href="/">Home</a>
                <a class="nav-item nav-link ${(selected_tab=="list")?string("active","")}" href="/list">List</a>
                <a class="nav-item nav-link ${(selected_tab=="edit")?string("active","")}" href="/edit">Add New</a>
            </div>
        </nav>
    </header>
</#macro>