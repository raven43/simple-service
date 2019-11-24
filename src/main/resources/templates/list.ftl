<#import "common.ftl" as common>

<@common.page "Simple Service" "list">
    <#if message?? && message?has_content>
        <div class="alert alert-info">
            ${message}
        </div>
    </#if>
    <#list list as service>
        <div class="row my-2 mx-0">
            <div class="col-auto">
                <a href="/service/${service.id}">
                    <img src="<#if service.imageUrl?? && service.imageUrl?has_content>
                        ${service.imageUrl}
                        <#else>
                        /static/default.png
                        </#if>"
                         class="icon-md">
                </a>

            </div>
            <div class="col">
                <div class="card">
                    <div class="card-header py-2 d-flex justify-content-between">
                        <h5 class="card-title m-0"><a href="/service/${service.id}">${service.name}</a></h5>
                        <div class="btn-group">
                            <form method="get" action="/edit/${service.id}">
                                <button type="submit" class="btn btn-info">Edit</button>
                            </form>
                            <form method="post" action="/service/${service.id}/delete">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                    <div class="card-body w-100 text-muted py-2">
                        Service Name: ${service.name}
                        <br>
                        Device: ${service.device.displayName}
                        <br>
                        Device Producer: ${service.producer}
                        <br>
                        Device Model: ${service.model}
                        <br>
                        Service Type: ${service.type}
                        <br>
                        Term (Days): ${service.getTermDays()}
                        <br>
                        Cost (BYN): ${service.cost}
                    </div>
                </div>
            </div>
        </div>
    </#list>

</@common.page>